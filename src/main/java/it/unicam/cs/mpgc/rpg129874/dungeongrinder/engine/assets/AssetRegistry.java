package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.assets;

import java.awt.image.BufferedImage;
import java.util.EnumMap;
import java.util.Map;

public class AssetRegistry {
    private static AssetRegistry instance;
    private static final Map<AssetKey, BufferedImage> loadedAssets = new EnumMap<>(AssetKey.class);

    private AssetRegistry() {
        loadAssets();
    }

    private void loadAssets() {
        for (AssetKey value : AssetKey.values()) {
            loadedAssets.put(value, value.getAsImage());
        }
    }

    private BufferedImage getAsset(AssetKey key) {
        return loadedAssets.get(key);
    }

    public static AssetRegistry getInstance() {
        if (instance == null) {
            instance = new AssetRegistry();
        }

        return instance;
    }
}
