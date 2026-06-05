package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder.Vector2D;

import static it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant.*;

public class Position implements Cloneable {
    private int x;
    private int y;

    public Position() {
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance(Position otherPosition) {
        int deltaX = this.x - otherPosition.getX();
        int deltaY = this.y - otherPosition.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public static Position center() {
        return new Position(APP_WIDTH / 2, APP_HEIGHT / 2);
    }

    public TilePosition toTilePosition() {
        return new TilePosition(x / TILE_SIZE, y / TILE_SIZE);
    }

    public void apply(Vector2D vector) {
        this.x += vector.x();
        this.y += vector.y();
    }

    @Override
    public Position clone() {
        try {
            Position clone = (Position) super.clone();
            clone.x = x;
            clone.y = y;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
