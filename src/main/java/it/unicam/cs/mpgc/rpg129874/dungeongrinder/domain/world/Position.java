package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world;

import static it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant.*;

public class Position {
    public static Position CENTER = new Position(APP_WIDTH / 2, APP_HEIGHT / 2);

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

    public Position toRoomPosition() {
        return new Position(x / TILE_SIZE, y / TILE_SIZE);
    }
}
