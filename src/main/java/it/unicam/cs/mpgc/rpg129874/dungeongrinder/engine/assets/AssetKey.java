package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.assets;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.Launcher;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public enum AssetKey {
    SKELETON("skeleton"),
    ZOMBIE("zombie")
    ;


    private final String path;
    AssetKey(String path) {
        this.path = path;
    }

    public BufferedImage getAsImage() {
        try (InputStream resourceAsStream = Launcher.class.getClassLoader().getResourceAsStream("assets/" + path + ".png")) {
            if (resourceAsStream == null) return null;
            return ImageIO.read(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
