package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.physics;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.Entity;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder.Vector2D;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldEnvironment;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;

import java.util.Set;

public class MovementSystem {
    private final WorldEnvironment environment;

    public MovementSystem(WorldEnvironment environment) {
        this.environment = environment;
    }

    public void update() {
        Set<Entity> entities = environment.getEntityContainer().getEntities();

        for (Entity entity : entities) {
            Vector2D velocity = entity.getVelocity();
            if (velocity == null || velocity.isStill()) continue;

            Position currentPos = entity.getPosition();
            Position nextPosFull = currentPos.clone();
            nextPosFull.apply(velocity);

            if (environment.isAreaWalkable(nextPosFull)) {
                currentPos.setX(nextPosFull.getX());
                currentPos.setY(nextPosFull.getY());
            } else {
                Position nextPositionX = currentPos.clone();
                nextPositionX.apply(new Vector2D(velocity.x(), 0));
                if (environment.isAreaWalkable(nextPositionX)) {
                    currentPos.setX(nextPositionX.getX());
                }

                Position nextPositionY = currentPos.clone();
                nextPositionY.apply(new Vector2D(0, velocity.y()));
                if (environment.isAreaWalkable(nextPositionY)) {
                    currentPos.setY(nextPositionY.getY());
                }
            }

            entity.setVelocity(Vector2D.zero());
        }
    }
}
