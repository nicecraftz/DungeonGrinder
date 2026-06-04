package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Direction;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldMap;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.MovementSystem;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.GameView;
import javafx.scene.input.KeyCode;

import java.util.HashSet;

public class InputController {
    private final HashSet<KeyCode> pressedKeys = new HashSet<>();
    private final GameView gameView;
    private final MovementSystem movementSystem;

    public InputController(GameView gameView, MovementSystem movementSystem) {
        this.gameView = gameView;
        this.movementSystem = movementSystem;
        configureInputListener();
    }

    private void configureInputListener() {
        gameView.sceneProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) return;
            newValue.setOnKeyPressed(event -> {
                KeyCode code = event.getCode();
                if (code == KeyCode.F3) gameView.toggleDebugOverlay();
                pressedKeys.add(code);
            });
            newValue.setOnKeyReleased(event -> pressedKeys.remove(event.getCode()));
        });
    }

    public void processInput() {
        if (pressedKeys.isEmpty()) return;
        if (pressedKeys.contains(KeyCode.W)) movementSystem.tryMove(Direction.UP);
        if (pressedKeys.contains(KeyCode.S)) movementSystem.tryMove(Direction.DOWN);
        if (pressedKeys.contains(KeyCode.A)) movementSystem.tryMove(Direction.LEFT);
        if (pressedKeys.contains(KeyCode.D)) movementSystem.tryMove(Direction.RIGHT);
    }
}
