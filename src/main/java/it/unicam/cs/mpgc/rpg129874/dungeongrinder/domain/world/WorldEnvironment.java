package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.EntityContainer;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room.GameRoom;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room.TileType;

public interface WorldEnvironment {

    long getSeed();

    TileType getTileAt(int x, int y);

    boolean isAreaWalkable(int x, int y);

    EntityContainer getEntityContainer();

    default Player getPlayer() {
        return getEntityContainer().getPlayer();
    }

    default TileType getTileAt(Position position) {
        return getTileAt(position.getX(), position.getY());
    }

    default boolean isAreaWalkable(Position position) {
        return isAreaWalkable(position.getX(), position.getY());
    }

    GameRoom getCurrentRoom();

    void setCurrentRoom(GameRoom room);
}
