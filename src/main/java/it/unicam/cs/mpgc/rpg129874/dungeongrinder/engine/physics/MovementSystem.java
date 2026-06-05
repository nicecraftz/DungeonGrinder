package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.physics;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.Entity;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldEnvironment;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Direction;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;

public class MovementSystem {
    private final WorldEnvironment environment;

    public MovementSystem(WorldEnvironment environment) {
        this.environment = environment;
    }

    public void tryMove(Entity entity, Direction direction) {
        Position position = entity.getPosition();
        int speed = entity.getDescriptor().attributes().speed();

        int oldX = position.getX();
        int oldY = position.getY();

        boolean movedY = false;
        if (direction == Direction.UP) {
            movedY = true;
            position.setY(position.getY() - speed);
        }

        if (direction == Direction.DOWN) {
            movedY = true;
            position.setY(position.getY() + speed);
        }

        if (movedY && !environment.isAreaWalkable(position)) {
            position.setY(oldY);
        }

        boolean movedX = false;
        if (direction == Direction.LEFT) {
            position.setX(position.getX() - speed);
            movedX = true;
        }
        if (direction == Direction.RIGHT) {
            position.setX(position.getX() + speed);
            movedX = true;
        }

        if (movedX && !environment.isAreaWalkable(position)) {
            position.setX(oldX);
        }
    }
}
