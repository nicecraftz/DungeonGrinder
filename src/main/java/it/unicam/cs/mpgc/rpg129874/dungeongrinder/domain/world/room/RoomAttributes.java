package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room;

import java.util.Random;

public class RoomAttributes {
    private static final int MAX_CHEST_PER_ROOM = 5;
    private static final int MIN_CHEST_PER_ROOM = 2;

    private static final int MIN_ENEMIES_PER_ROOM = 5;
    private static final int MAX_ENEMIES_PER_ROOM = 10;

    private final int chests;
    private final int enemies;

    public RoomAttributes(long seed) {
        Random random = new Random(seed);
        this.chests = random.nextInt(MIN_CHEST_PER_ROOM, MAX_CHEST_PER_ROOM);
        this.enemies = random.nextInt(MIN_ENEMIES_PER_ROOM, MAX_ENEMIES_PER_ROOM);
    }

    public int getChests() {
        return chests;
    }

    public int getEnemies() {
        return enemies;
    }
}
