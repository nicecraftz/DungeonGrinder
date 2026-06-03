package it.unicam.cs.mpgc.rpg129874.dungeongrinder;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller.GameController;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldMap;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.WorldMapView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DungeonGrinderApplication extends Application {
    public static final String APPLICATION_NAME = "Dungeon Grinder";

    @Override
    public void start(Stage stage) {
        stage.setTitle(APPLICATION_NAME);
        stage.setWidth(Constant.NORMALIZED_APP_WIDTH);
        stage.setHeight(Constant.NORMALIZED_APP_HEIGHT);
        
        WorldMap mapModel = new WorldMap();
        WorldMapView mapView = new WorldMapView();
        GameController controller = new GameController(mapModel, mapView);

        Scene gameScene = new Scene(mapView);
        stage.setScene(gameScene);
        stage.show();
    }
}
