package it.unicam.cs.mpgc.rpg129874.dungeongrinder;

import java.awt.*;

public interface Constant {
    int DESKTOP_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    int DESKTOP_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    int APP_VIEW_RATIO = 2;

    int TILE_SIZE = 32;

    int WIDTH = DESKTOP_WIDTH / APP_VIEW_RATIO;
    int HEIGHT = DESKTOP_HEIGHT / APP_VIEW_RATIO;

    int APP_WIDTH = WIDTH - (WIDTH % TILE_SIZE);
    int APP_HEIGHT = HEIGHT - (HEIGHT % TILE_SIZE);

    int MAP_WIDTH = APP_WIDTH / TILE_SIZE;
    int MAP_HEIGHT = APP_HEIGHT / TILE_SIZE;
}
