package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller.world;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldEnvironment;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.TilePosition;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room.GameRoom;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room.RoomPoint;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room.TileType;

public class RoomController {
    private final WorldEnvironment environment;

    public RoomController(WorldEnvironment environment) {
        this.environment = environment;
    }

    public void checkRoomTransition() {
        Player player = environment.getPlayer();
        TilePosition tilePosition = player.getPosition().toTilePosition();
        if (environment.getTileAt(tilePosition.x(), tilePosition.y()) != TileType.DOOR) return;

        RoomPoint currentPoint = environment.getCurrentRoom().getPoint();

        int tileY = tilePosition.y();
        int tileX = tilePosition.x();
        GameRoom nextRoom = getNextRoom(currentPoint, tileY, tileX);
        environment.setCurrentRoom(nextRoom);

        repositionPlayer(player, tileX, tileY);
    }

    private void repositionPlayer(Player player, int oldTileX, int oldTileY) {
        int newX = player.getPosition().getX();
        int newY = player.getPosition().getY();

        if (oldTileY == 0) newY = (Constant.MAP_HEIGHT - 2) * Constant.TILE_SIZE;
        else if (oldTileY == Constant.MAP_HEIGHT - 1) newY = Constant.TILE_SIZE;
        else if (oldTileX == 0) newX = (Constant.MAP_WIDTH - 2) * Constant.TILE_SIZE;
        else if (oldTileX == Constant.MAP_WIDTH - 1) newX = Constant.TILE_SIZE;

        player.getPosition().setX(newX);
        player.getPosition().setY(newY);
    }

    private GameRoom getNextRoom(RoomPoint currentPoint, int tileY, int tileX) {
        int nextX = currentPoint.x();
        int nextY = currentPoint.y();

        if (tileY == 0) nextY--;
        else if (tileY == Constant.MAP_HEIGHT - 1) nextY++;
        else if (tileX == 0) nextX--;
        else if (tileX == Constant.MAP_WIDTH - 1) nextX++;

        return new GameRoom(environment, new RoomPoint(nextX, nextY));
    }
}
