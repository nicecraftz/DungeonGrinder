package it.unicam.cs.mpgc.rpg129874.dungeongrinder;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller.GameController;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldMap;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DungeonGrinderApplication extends Application {
    public static final String APPLICATION_NAME = "Dungeon Grinder";

    @Override
    public void start(Stage stage) {
        stage.setResizable(false);
        stage.setTitle(APPLICATION_NAME);

        WorldMap mapModel = new WorldMap();
        GameView mapView = new GameView();
        new GameController(mapModel, mapView);

        Scene gameScene = new Scene(mapView, Constant.APP_WIDTH, Constant.APP_HEIGHT);

        stage.setScene(gameScene);
        stage.show();
    }
}
