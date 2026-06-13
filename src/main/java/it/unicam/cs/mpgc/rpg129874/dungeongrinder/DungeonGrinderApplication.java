package it.unicam.cs.mpgc.rpg129874.dungeongrinder;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller.GameController;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller.StartMenuController;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldMap;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.*;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.event.RoomTransitionEvent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
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

        StackPane root = new StackPane();
        GameView gameView = new GameView();
        StatusView statusView = new StatusView();
        DebugOverlayView debugOverlayView = new DebugOverlayView();
        TransitionOverlayView transitionOverlayView = new TransitionOverlayView();

        root.getChildren().addAll(gameView, statusView, debugOverlayView, transitionOverlayView);

        new GameController(worldMap, gameView, debugOverlayView, statusView);

        root.addEventHandler(RoomTransitionEvent.TRANSITION_REQUESTED, event ->
                transitionOverlayView.startBlink(event::executeMidPointCallback, event::executeEndCallback));

        stage.getScene().setRoot(root);
    }
}
