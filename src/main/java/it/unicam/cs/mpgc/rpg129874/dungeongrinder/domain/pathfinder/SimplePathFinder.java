package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;

public class SimplePathFinder implements Pathfinder {
    private static final double DISTANCE_TRESHOLD = 0.1;

    @Override
    public Vector2D calculateMovement(Position origin, Position target, int stepSpeed) {
        if (origin == null || target == null) {
            throw new IllegalArgumentException("Origin and target cannot be null");
        }

        double deltaX = target.getX() - origin.getX();
        double deltaY = target.getY() - origin.getY();

        double distance = Math.hypot(deltaX, deltaY);

        if (distance < DISTANCE_TRESHOLD) {
            return new Vector2D(0, 0);
        }

        if (distance <= stepSpeed) {
            return new Vector2D(deltaX, deltaY);
        }

        double moveX = (deltaX / distance) * stepSpeed;
        double moveY = (deltaY / distance) * stepSpeed;

        return new Vector2D(moveX, moveY);
    }
}
