package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder;


public record Vector2D(int x, int y) {
    public Vector2D withSpeed(int speed) {
        return new Vector2D(x * speed, y * speed);
    }

    public static Vector2D zero() {
        return new Vector2D(0, 0);
    }

    public Vector2D add(Vector2D vector2D) {
        return new Vector2D(x + vector2D.x, y + vector2D.y);
    }

    public boolean isStill() {
        return x == 0 && y == 0;
    }
}
