package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldEnvironment;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Point;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.DebugOverlayView;
import javafx.scene.input.KeyCode;

public class DebugOverlayController {
    private final DebugOverlayView view;

    public DebugOverlayController(DebugOverlayView view) {
        this.view = view;
        view.sceneProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) return;
            newValue.setOnKeyPressed(event -> {
                if (event.getCode() != KeyCode.F3) return;
                view.setVisible(!view.isVisible());
            });
        });
    }

    public void update(WorldEnvironment worldEnvironment) {
        if (!view.isVisible()) return;
        Position position = worldEnvironment.getPlayer().getPosition();
        view.setRawCoordinates(position.getX(), position.getY());
        view.setRoomSeed(worldEnvironment.getCurrentRoom().getSeed());
        Point roomPosition = worldEnvironment.getCurrentRoom().getPoint();
        view.setRoomCoordinates(roomPosition.x(), roomPosition.y());
        view.setCoordinates(position.getX() / Constant.TILE_SIZE, position.getY() / Constant.TILE_SIZE);
    }

}
