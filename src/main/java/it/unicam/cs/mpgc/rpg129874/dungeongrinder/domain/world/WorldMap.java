package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.Entity;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class WorldMap {
    public static final long SEED = ThreadLocalRandom.current().nextLong();
    private GameRoom gameRoom = new GameRoom(0, 0);
    private Set<Entity> entities = new HashSet<>();
    private int[][] grid = gameRoom.getGrid();

    public void setGameRoom(GameRoom gameRoom) {
        this.gameRoom = gameRoom;
        this.grid = gameRoom.getGrid();
    }

    public int[][] getGrid() {
        return grid;
    }

    public GameRoom getGameRoom() {
        return gameRoom;
    }

    public boolean isAreaWalkable(int x, int y, int width, int height) {
        if (x < 0 || x + width > Constant.APP_WIDTH ||
            y < 0 || y + height > Constant.APP_HEIGHT) {
            return false;
        }

        int tileX1 = x / Constant.TILE_SIZE;
        int tileY1 = y / Constant.TILE_SIZE;
        int tileX2 = (x + width - 1) / Constant.TILE_SIZE;
        int tileY2 = (y + height - 1) / Constant.TILE_SIZE;

        return !isWallTile(tileX1, tileY1) && !isWallTile(tileX2, tileY1) &&
               !isWallTile(tileX1, tileY2) && !isWallTile(tileX2, tileY2);
    }

    public boolean isWallTile(int tileX, int tileY) {
        if (tileX < 0 || tileX >= Constant.MAP_WIDTH || tileY < 0 || tileY >= Constant.MAP_HEIGHT) {
            return true;
        }
        return grid[tileX][tileY] == RoomGenerator.ROOM_WALL;
    }

    public boolean isChestTile(int x, int y) {
        return grid[x][y] == RoomGenerator.CHEST;
    }

    public boolean isDoorTile(int x, int y) {
        return grid[x][y] == RoomGenerator.ROOM_DOOR_LOCK;
    }
}
