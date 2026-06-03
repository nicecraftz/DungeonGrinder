package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.HumanEntity;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.GameRoom;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.Position;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldMap;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.DebugOverlayView;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.GameView;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;

import java.util.HashSet;

public class GameController extends AnimationTimer {
    private static final long FRAMES_PER_SECOND = 60;
    private static final long NANOS_PER_FRAME = 1_000_000_000 / FRAMES_PER_SECOND;

    private final HashSet<KeyCode> pressedKeys = new HashSet<>();

    private final WorldMap worldMapModel;
    private final GameView gameView;
    private final DebugOverlayView debugOverlay;

    private final HumanEntity humanEntity = new Player();
    private long previousTime = 0;

    public GameController(WorldMap worldMapModel, GameView gameView) {
        this.worldMapModel = worldMapModel;
        this.gameView = gameView;
        this.debugOverlay = gameView.getDebugOverlay();

        configureInput();
        start();
    }

    private void processInput() {
        int oldX = humanEntity.getPosition().getX();
        int oldY = humanEntity.getPosition().getY();
        
        boolean movedY = false;
        if (pressedKeys.contains(KeyCode.W)) { humanEntity.moveForward(); movedY = true; }
        if (pressedKeys.contains(KeyCode.S)) { humanEntity.moveBackwards(); movedY = true; }
        
        if (movedY && !isValidPosition(humanEntity.getPosition())) {
            humanEntity.getPosition().setY(oldY);
        }
        
        boolean movedX = false;
        if (pressedKeys.contains(KeyCode.A)) { humanEntity.moveLeft(); movedX = true; }
        if (pressedKeys.contains(KeyCode.D)) { humanEntity.moveRight(); movedX = true; }
        
        if (movedX && !isValidPosition(humanEntity.getPosition())) {
            humanEntity.getPosition().setX(oldX);
        }
    }

    private boolean isValidPosition(Position pos) {
        return worldMapModel.isAreaWalkable(pos.getX(), pos.getY(), Constant.TILE_SIZE, Constant.TILE_SIZE);
    }

    private void configureInput() {
        gameView.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene == null) return;
            newScene.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.F3) debugOverlay.setVisible(!debugOverlay.isVisible());
                pressedKeys.add(keyEvent.getCode());
            });
            newScene.setOnKeyReleased(keyEvent -> pressedKeys.remove(keyEvent.getCode()));
        });
    }

    public void updateRender() {
        gameView.render(worldMapModel, humanEntity);
    }

    @Override
    public void handle(long now) {
        long timePassed = now - previousTime;
        if (timePassed >= NANOS_PER_FRAME) {
            processInput();
            updateDebugScreen();
            updateRender();
            previousTime = now;
        }
    }

    private void updateDebugScreen() {
        if (!debugOverlay.isVisible()) return;
        Position position = humanEntity.getPosition();
        GameRoom gameRoom = worldMapModel.getGameRoom();
        debugOverlay.setRawCoordinates(position.getX(), position.getY());
        debugOverlay.setRoomSeed(gameRoom.getRoomSeed());
        debugOverlay.setRoomCoordinates(gameRoom.getX(), gameRoom.getY());
        debugOverlay.setCoordinates(position.getX() / Constant.TILE_SIZE, position.getY() / Constant.TILE_SIZE);
    }
}
