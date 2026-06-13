package it.unicam.cs.mpgc.rpg129874.dungeongrinder;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller.GameController;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller.StartMenuController;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldMap;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.GameView;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.StartMenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DungeonGrinderApplication extends Application {
    public static final String APPLICATION_NAME = "Dungeon Grinder";

    @Override
    public void start(Stage stage) {
        stage.setResizable(false);
        stage.setTitle(APPLICATION_NAME);

        StartMenuView startMenuView = new StartMenuView();
        new StartMenuController(startMenuView, seed -> startGame(stage, seed));
        Scene gameScene = new Scene(startMenuView, Constant.APP_WIDTH, Constant.APP_HEIGHT);
        stage.setScene(gameScene);
        stage.show();
    }

    private void startGame(Stage stage, long seed) {
        WorldMap worldMap = new WorldMap(seed);
        GameView mapView = new GameView();
        new GameController(worldMap, mapView);
        stage.getScene().setRoot(mapView);
    }
}
