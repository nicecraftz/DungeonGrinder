package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldMap;
import javafx.scene.image.Image;

import java.util.List;
import java.util.Random;

public class AssetBundle {
    private static final Random RANDOM = new Random(WorldMap.SEED);
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

    public Image getRandom() {
        return images.get(RANDOM.nextInt(images.size()));
    }

    public Image getVariant(int variant) {
        return images.get(variant % images.size());
    }

    public int getFramesCount() {
        return images.size();
    }
}
