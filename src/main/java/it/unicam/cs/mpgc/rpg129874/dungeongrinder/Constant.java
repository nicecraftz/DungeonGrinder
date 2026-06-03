package it.unicam.cs.mpgc.rpg129874.dungeongrinder;

import java.awt.*;

public interface Constant {
    int DESKTOP_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    int DESKTOP_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    int APP_VIEW_RATIO = 2;

    int APP_WIDTH = DESKTOP_WIDTH / APP_VIEW_RATIO;
    int APP_HEIGHT = DESKTOP_HEIGHT / APP_VIEW_RATIO;

    int NORMALIZED_APP_WIDTH = APP_WIDTH - (APP_WIDTH % 64);
    int NORMALIZED_APP_HEIGHT = APP_HEIGHT - (APP_WIDTH % 64);

    int TILE_SIZE = 64;
    
    int TILE_WIDTH = NORMALIZED_APP_WIDTH / TILE_SIZE;
    int TILE_HEIGHT = NORMALIZED_APP_HEIGHT / TILE_SIZE;

}
