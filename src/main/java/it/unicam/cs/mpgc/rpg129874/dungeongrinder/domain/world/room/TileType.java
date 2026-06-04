package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.AssetKey;

public enum TileType {
    WALL(false, AssetKey.ROOM_WALL),
    FLOOR(true, AssetKey.ROOM_FLOOR),
    CHEST(false, AssetKey.CHEST),
    DOOR(true, AssetKey.HOLE),
    DOOR_LOCK(true, AssetKey.ROOM_FLOOR);

    private final boolean walkable;
    private final AssetKey assetKey;

    TileType(boolean walkable, AssetKey assetKey) {
        this.walkable = walkable;
        this.assetKey = assetKey;
    }

    public boolean isWalkable() {
        return walkable;
    }

    public AssetKey getAssetKey() {
        return assetKey;
    }
}
