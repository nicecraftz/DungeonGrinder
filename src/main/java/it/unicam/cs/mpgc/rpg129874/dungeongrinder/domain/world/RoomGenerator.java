package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant;

import java.util.Random;

import static it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant.*;

public class RoomGenerator {
    private static final int ROOM_WALL = 1;
    private static final int ROOM_FLOOR = 2;
    private static final int CHEST = 3;
    private static final int ENEMY = 4;
    private static final int ROOM_DOOR = 5;

    private static final int MIN_CHEST_COUNT = 1;
    private static final int MAX_CHEST_COUNT = 4;

    private static final int MIN_ENEMY_COUNT = 3;
    private static final int MAX_ENEMY_COUNT = 5;

    public static int[][] generateRoomGrid(long worldSeed, int roomX, int roomY) {
        long roomSeed = worldSeed ^ (roomX * 23099561L) ^ (roomY * 34555567L);
        Random random = new Random(roomSeed);

        int[][] roomMap = new int[Constant.TILE_WIDTH][TILE_HEIGHT];
        setupRoomWalls(roomMap);
        setupDoors(roomMap);
        setupRoomChests(random, roomMap);
        setupEnemies(random, roomMap);
        return roomMap;
    }

    private static void setupDoors(int[][] roomMap) {
        roomMap[TILE_WIDTH / 2][TILE_HEIGHT - 1] = ROOM_DOOR;
        roomMap[TILE_WIDTH - 1][TILE_HEIGHT / 2] = ROOM_DOOR;
        roomMap[TILE_WIDTH / 2][0] = ROOM_DOOR;
        roomMap[0][TILE_HEIGHT / 2] = ROOM_DOOR;
    }

    private static void setupEnemies(Random random, int[][] roomMap) {
        shufflePlace(random, roomMap, MIN_ENEMY_COUNT, MAX_ENEMY_COUNT, ENEMY);
    }

    private static void setupRoomChests(Random random, int[][] roomMap) {
        shufflePlace(random, roomMap, MIN_CHEST_COUNT, MAX_CHEST_COUNT, CHEST);
    }

    private static void setupRoomWalls(int[][] roomMap) {
        for (int x = 0; x < Constant.TILE_WIDTH; x++) {
            for (int y = 0; y < TILE_HEIGHT; y++) {
                if (isWall(x, y)) roomMap[x][y] = ROOM_WALL;
                else roomMap[x][y] = ROOM_FLOOR;
            }
        }
    }

    private static boolean isWall(int x, int y) {
        return x == 0 || y == 0 || x == TILE_WIDTH - 1 || y == TILE_HEIGHT - 1;
    }

    private static boolean isOccupied(int[][] roomMap, int x, int y) {
        return roomMap[x][y] != ROOM_FLOOR;
    }

    private static void shufflePlace(Random random, int[][] roomMap, int min, int max, int tile) {
        int targetCount = random.nextInt(min, max + 1);
        int placed = 0;

        while (placed < targetCount) {
            int x = random.nextInt(TILE_WIDTH);
            int y = random.nextInt(TILE_HEIGHT);

            if (isWall(x, y) || isOccupied(roomMap, x, y)) {
                continue;
            }

            roomMap[x][y] = tile;
            placed++;
        }
    }
}
