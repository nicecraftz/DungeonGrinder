package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.EntityContainer;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.TilePosition;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room.GameRoom;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room.TileType;

public interface WorldEnvironment {

    long getSeed();

    TileType getTileAt(int x, int y);

    EntityContainer getEntityContainer();

    default Player getPlayer() {
        return getEntityContainer().getPlayer();
    }

    boolean isAreaWalkable(int x, int y);

    default boolean isAreaWalkable(Position position) {
        return isAreaWalkable(position.getX(), position.getY());
    }

    default TileType getTileAt(TilePosition tilePosition) {
        return getTileAt(tilePosition.x(), tilePosition.y());
    }

    GameRoom getCurrentRoom();

    void setCurrentRoom(GameRoom room);
}
