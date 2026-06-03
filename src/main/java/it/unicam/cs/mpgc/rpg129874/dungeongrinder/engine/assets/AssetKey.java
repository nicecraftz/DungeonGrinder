package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.assets;

import javafx.scene.image.Image;

public enum AssetKey {
    SKELETON("skeleton"),
    ZOMBIE("zombie"),
    ROOM_FLOOR("tiles/room_floor"),
    ROOM_WALL("tiles/room_wall")
    ;


    private final String path;
    AssetKey(String path) {
        this.path = path;
    }

    public Image getAsImage() {
        return new Image("assets/" + path + ".png");
    }
}
