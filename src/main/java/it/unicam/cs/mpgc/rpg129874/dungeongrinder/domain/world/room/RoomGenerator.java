package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant;

import java.util.Random;

import static it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant.*;

public class RoomGenerator {

    public static TileType[][] generateRoomGrid(long seed, RoomAttributes roomAttributes) {
        Random random = new Random(seed);
        TileType[][] roomMap = new TileType[Constant.MAP_WIDTH][MAP_HEIGHT];
        setupRoomWalls(roomMap);
        setupDoors(roomMap);
        setupRoomChests(random, roomMap, roomAttributes.getChests());
        return roomMap;
    }

    private static void setupDoors(TileType[][] roomMap) {
        int midX = MAP_WIDTH / 2;
        int midY = MAP_HEIGHT / 2;
        applyDoorZone(roomMap, midX, MAP_HEIGHT - 1, 0, -1);
        applyDoorZone(roomMap, midX, 0, 0, 1);
        applyDoorZone(roomMap, MAP_WIDTH - 1, midY, -1, 0);
        applyDoorZone(roomMap, 0, midY, 1, 0);
    }

    private static void applyDoorZone(TileType[][] roomMap, int doorX, int doorY, int offsetX, int offsetY) {
        roomMap[doorX][doorY] = TileType.DOOR;
        roomMap[doorX + offsetX][doorY + offsetY] = TileType.DOOR_LOCK;
    }

    private static void setupRoomChests(Random random, TileType[][] roomMap, int chestCount) {
        shufflePlace(random, roomMap, chestCount, TileType.CHEST);
    }

    private static void setupRoomWalls(TileType[][] roomMap) {
        for (int x = 0; x < Constant.MAP_WIDTH; x++) {
            for (int y = 0; y < MAP_HEIGHT; y++) {
                if (isWall(x, y)) roomMap[x][y] = TileType.WALL;
                else roomMap[x][y] = TileType.FLOOR;
            }
        }
    }

    private static boolean isWall(int x, int y) {
        return x == 0 || y == 0 || x == MAP_WIDTH - 1 || y == MAP_HEIGHT - 1;
    }

    private static boolean isOccupied(TileType[][] roomMap, int x, int y) {
        return roomMap[x][y] != TileType.FLOOR;
    }

    private static void shufflePlace(Random random, TileType[][] roomMap, int targetCount, TileType tile) {
        int placed = 0;

        while (placed < targetCount) {
            int x = random.nextInt(MAP_WIDTH);
            int y = random.nextInt(MAP_HEIGHT);

            if (isWall(x, y) || isOccupied(roomMap, x, y)) {
                continue;
            }

            roomMap[x][y] = tile;
            placed++;
        }
    }
}
