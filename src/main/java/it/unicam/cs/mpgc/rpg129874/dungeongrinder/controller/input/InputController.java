package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller.input;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder.Vector2D;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.physics.MovementSystem;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.DebugOverlayView;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.GameView;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.StatusView;
import javafx.scene.input.KeyCode;

import java.util.HashSet;

public class InputController {
    private final HashSet<KeyCode> pressedKeys = new HashSet<>();
    private final GameView gameView;
    private final DebugOverlayView debugOverlayView;
    private final StatusView statusView;
    private final MovementSystem movementSystem;
    private final MovementInputController movementInputController;
    private final ActionInputController actionInputController;
    private final Player player;

    public InputController(GameView gameView, DebugOverlayView debugOverlayView, StatusView statusView, MovementSystem movementSystem, Player player) {
        this.gameView = gameView;
        this.debugOverlayView = debugOverlayView;
        this.statusView = statusView;
        this.movementSystem = movementSystem;
        this.player = player;
        this.movementInputController = new MovementInputController();
        this.actionInputController = new ActionInputController();
        configureInputListener();
    }

    private void configureInputListener() {
        gameView.sceneProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) return;
            newValue.setOnKeyPressed(event -> {
                KeyCode code = event.getCode();
                if (code == KeyCode.F3) {
                    boolean isDebugVisible = !debugOverlayView.isVisible();
                    debugOverlayView.setVisible(isDebugVisible);
                    statusView.setVisible(!isDebugVisible);
                }
                pressedKeys.add(code);
            });
            newValue.setOnKeyReleased(event -> pressedKeys.remove(event.getCode()));
        });
    }

    public void processInput() {
        player.setVelocity(Vector2D.zero());
        if (pressedKeys.isEmpty()) return;
        movementInputController.process(pressedKeys, player);
        actionInputController.process(pressedKeys, player);
    }
}
