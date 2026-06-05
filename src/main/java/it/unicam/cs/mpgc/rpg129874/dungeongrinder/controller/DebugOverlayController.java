package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder.Vector2D;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldEnvironment;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room.RoomPoint;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.TilePosition;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room.GameRoom;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.DebugOverlayView;

public class DebugOverlayController {
    private final DebugOverlayView view;

    public DebugOverlayController(DebugOverlayView view) {
        this.view = view;
    }

    public void update(WorldEnvironment worldEnvironment, double fps) {
        if (!view.isVisible()) return;
        view.setFps(fps);
        Player player = worldEnvironment.getPlayer();
        Position position = player.getPosition();
        view.setRawCoordinates(position.getX(), position.getY());

        GameRoom currentRoom = worldEnvironment.getCurrentRoom();
        view.setRoomSeed(currentRoom.getSeed());

        RoomPoint roomPosition = currentRoom.getPoint();
        view.setRoomCoordinates(roomPosition.x(), roomPosition.y());

        TilePosition tilePosition = position.toTilePosition();
        view.setCoordinates(tilePosition.x(), tilePosition.y());
        view.setCurrentTile(worldEnvironment.getTileAt(tilePosition));

        Vector2D velocity = player.getVelocity();
        view.setCurrentVelocity(velocity.x(), velocity.y());
    }
}
