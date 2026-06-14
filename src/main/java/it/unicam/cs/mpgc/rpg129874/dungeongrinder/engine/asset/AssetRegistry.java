package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.asset;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class AssetRegistry {
    private static AssetRegistry instance;
    private static final Map<AssetKey, AssetBundle> LOADED_ASSETS = new EnumMap<>(AssetKey.class);

    private AssetRegistry() {
        loadAssets();
    }

    private void loadAssets() {
        for (AssetKey key : AssetKey.values()) {
            List<Image> frames = new ArrayList<>();
            System.out.println("Loading asset family for " + key.name());
            for (int i = 0; i < key.getFrameCount(); i++) {
                String suffix = key.getFrameCount() > 1 ? "_" + i : "";
                String fullPath = "assets/" + key.getBasePath() + suffix + ".png";
                String resourcePath = "/" + fullPath;
                String url = AssetRegistry.class.getResource(resourcePath).toExternalForm();
                frames.add(new Image(url));
            }
            LOADED_ASSETS.put(key, new AssetBundle(frames));
        }
    }

    public AssetBundle getAsset(AssetKey key) {
        return LOADED_ASSETS.get(key);
    }

    public static AssetRegistry getInstance() {
        if (instance == null) {
            instance = new AssetRegistry();
        }

        return instance;
    }
}
