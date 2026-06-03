package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.assets;

import javafx.scene.image.Image;

import java.util.EnumMap;
import java.util.Map;

public class AssetRegistry {
    private static AssetRegistry instance;
    private static final Map<AssetKey, Image> loadedAssets = new EnumMap<>(AssetKey.class);

    private AssetRegistry() {
        loadAssets();
    }

    private void loadAssets() {
        for (AssetKey value : AssetKey.values()) {
            loadedAssets.put(value, value.getAsImage());
        }
    }

    public Image getAsset(AssetKey key) {
        return loadedAssets.get(key);
    }

    public static AssetRegistry getInstance() {
        if (instance == null) {
            instance = new AssetRegistry();
        }

        return instance;
    }
}
