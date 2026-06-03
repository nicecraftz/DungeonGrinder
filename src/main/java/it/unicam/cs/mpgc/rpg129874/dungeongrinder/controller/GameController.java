package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldMap;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.GameView;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;

public class GameController extends AnimationTimer {
    private static final long FRAMES_PER_SECOND = 60;
    private static final long NANOS_PER_FRAME = 1_000_000_000 / FRAMES_PER_SECOND;
    private long previousTime = 0;

    private final WorldMap worldMapModel;
    private final GameView gameView;

    public GameController(WorldMap worldMapModel, GameView gameView) {
        this.worldMapModel = worldMapModel;
        this.gameView = gameView;
        configureInput();
        start();
    }

    private void configureInput() {
        gameView.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene == null) return;
            newScene.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.F3) gameView.toggleDebugOverlay();
            });
        });
    }

    public void updateRender() {
        gameView.render(worldMapModel);
    }

    @Override
    public void handle(long now) {
        long timePassed = now - previousTime;
        if (timePassed >= NANOS_PER_FRAME) {
            updateRender();
            previousTime = now;
        }
    }
}
