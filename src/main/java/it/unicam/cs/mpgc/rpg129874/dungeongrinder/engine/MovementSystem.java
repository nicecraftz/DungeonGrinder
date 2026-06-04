package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldEnvironment;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Direction;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;

public class MovementSystem {
    private final WorldEnvironment environment;

    public MovementSystem(WorldEnvironment environment) {
        this.environment = environment;
    }

    public void tryMove(Direction direction) {
        Player player = environment.getPlayer();
        Position position = player.getPosition();

        int oldX = position.getX();
        int oldY = position.getY();

        boolean movedY = false;
        if (direction == Direction.UP) {
            movedY = true;
            player.moveForward();
        }

        if (direction == Direction.DOWN) {
            movedY = true;
            player.moveBackwards();
        }

        if (movedY && !environment.isAreaWalkable(position)) {
            position.setY(oldY);
        }

        boolean movedX = false;
        if (direction == Direction.LEFT) {
            player.moveLeft();
            movedX = true;
        }
        if (direction == Direction.RIGHT) {
            player.moveRight();
            movedX = true;
        }

        if (movedX && !environment.isAreaWalkable(position)) {
            position.setX(oldX);
        }
    }
}
