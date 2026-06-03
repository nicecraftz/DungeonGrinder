package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant;

import java.util.Random;

import static it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant.*;

public class RoomGenerator {
    public static final int ROOM_WALL = 1;
    public static final int ROOM_FLOOR = 2;
    public static final int CHEST = 3;
    public static final int ROOM_DOOR = 5;
    public static final int ROOM_DOOR_LOCK = 6;

    private static final int MIN_CHEST_COUNT = 1;
    private static final int MAX_CHEST_COUNT = 4;

    public static int[][] generateRoomGrid(long roomSeed) {
        Random random = new Random(roomSeed);
        int[][] roomMap = new int[Constant.MAP_WIDTH][MAP_HEIGHT];
        setupRoomWalls(roomMap);
        setupDoors(roomMap);
        setupRoomChests(random, roomMap);
        return roomMap;
    }

    private static void setupDoors(int[][] roomMap) {
        int midX = MAP_WIDTH / 2;
        int midY = MAP_HEIGHT / 2;
        applyDoorZone(roomMap, midX, MAP_HEIGHT - 1, 0, -1);
        applyDoorZone(roomMap, midX, 0, 0, 1);
        applyDoorZone(roomMap, MAP_WIDTH - 1, midY, -1, 0);
        applyDoorZone(roomMap, 0, midY, 1, 0);
    }

    private static void applyDoorZone(int[][] roomMap, int doorX, int doorY, int offsetX, int offsetY) {
        roomMap[doorX][doorY] = ROOM_DOOR;
        roomMap[doorX + offsetX][doorY + offsetY] = ROOM_DOOR_LOCK;
    }

    private static void setupRoomChests(Random random, int[][] roomMap) {
        shufflePlace(random, roomMap, MIN_CHEST_COUNT, MAX_CHEST_COUNT, CHEST);
    }

    private static void setupRoomWalls(int[][] roomMap) {
        for (int x = 0; x < Constant.MAP_WIDTH; x++) {
            for (int y = 0; y < MAP_HEIGHT; y++) {
                if (isWall(x, y)) roomMap[x][y] = ROOM_WALL;
                else roomMap[x][y] = ROOM_FLOOR;
            }
        }
    }

    private static boolean isWall(int x, int y) {
        return x == 0 || y == 0 || x == MAP_WIDTH - 1 || y == MAP_HEIGHT - 1;
    }

    private static boolean isOccupied(int[][] roomMap, int x, int y) {
        return roomMap[x][y] != ROOM_FLOOR;
    }

    private static void shufflePlace(Random random, int[][] roomMap, int min, int max, int tile) {
        int targetCount = random.nextInt(min, max + 1);
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
