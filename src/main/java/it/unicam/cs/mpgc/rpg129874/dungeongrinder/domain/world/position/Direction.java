package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder.Vector2D;

public enum Direction {
    UP(new Vector2D(0, -1)),
    DOWN(new Vector2D(0, 1)),
    RIGHT(new Vector2D(1, 0)),
    LEFT(new Vector2D(-1, 0)),
    ;

    private final Vector2D applyingVector;

    Direction(Vector2D applyingVector) {
        this.applyingVector = applyingVector;
    }

    public Vector2D toVectorWithSpeed(int speed) {
        return toVector().withSpeed(speed);
    }

    public Vector2D toVector() {
        return applyingVector;
    }
}
