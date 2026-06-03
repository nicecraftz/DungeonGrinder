package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine;

public enum AssetKey {
    ROOM_FLOOR("tiles/floor/room_floor", 8),
    ROOM_WALL("tiles/room_wall"),
    CHEST("tiles/chest/chest", 2),
    HOLE("tiles/hole"),
    CHORT_IDLE("entities/chort/chort_idle", 3),
    CHORT_RUN("entities/chort/chort_run", 3),
    DOC_IDLE("entities/doc/doc_idle", 3),
    DOC_RUN("entities/doc/doc_run", 3)
    ;


    private final String basePath;
    private final int frameCount;

    AssetKey(String basePath) {
        this(basePath, 1);
    }

    AssetKey(String basePath, int frameCount) {
        this.basePath = basePath;
        this.frameCount = frameCount;
    }

    public String getBasePath() {
        return basePath;
    }

    public int getFrameCount() {
        return frameCount;
    }
}
