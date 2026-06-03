package it.unicam.cs.mpgc.rpg129874.dungeongrinder.view;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller.GameController;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldMap;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameView extends VBox {
    private final Stage primaryStage;
    private final Scene mainMenuScene;

    public GameView(Stage primaryStage, Scene mainMenuScene) {
        this.primaryStage = primaryStage;
        this.mainMenuScene = mainMenuScene;
        setupMainMenuShortcut();
        setupGameViewStyle();
        addWorldMapView();
    }

    private void addWorldMapView() {
        WorldMap worldMap = new WorldMap();
        WorldMapView worldMapView = new WorldMapView();
        GameController gameController = new GameController(worldMap, worldMapView);
        getChildren().add(worldMapView);
    }

    private void setupGameViewStyle() {
        setStyle("-fx-background-color: #808080");
    }

    private void setupMainMenuShortcut() {
        sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene == null) return;
            newScene.setOnKeyPressed(e -> {
                if (e.getCode() != KeyCode.ESCAPE) return;
                primaryStage.setScene(mainMenuScene);
            });
        });
    }
}
