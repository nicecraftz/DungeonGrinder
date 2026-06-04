package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room;

public enum TileType {
    WALL(false),
    FLOOR(true),
    CHEST(false),
    DOOR(true),
    DOOR_LOCK(true);

    private final boolean walkable;

    TileType(boolean walkable) {
        this.walkable = walkable;
    }

    public boolean isWalkable() {
        return walkable;
    }

    public static TileType fromId(int id) {
        return switch (id) {
            case 1 -> WALL;
            case 3 -> CHEST;
            case 5 -> DOOR;
            case 6 -> DOOR_LOCK;
            default -> FLOOR;
        };
    }
}
