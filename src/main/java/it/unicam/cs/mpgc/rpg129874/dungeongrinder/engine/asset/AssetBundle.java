package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.asset;

import javafx.scene.image.Image;

import java.util.List;

public class AssetBundle {
    private final List<Image> images;

    public AssetBundle(List<Image> images) {
        if (images == null || images.isEmpty()) {
            throw new IllegalStateException("AssetBundle must have at least one image");
        }
        this.images = images;
    }

    public Image getDefaultImage() {
        return images.getFirst();
    }

    public Image getVariant(int variant) {
        return images.get(variant % images.size());
    }

    public int getFramesCount() {
        return images.size();
    }
}
