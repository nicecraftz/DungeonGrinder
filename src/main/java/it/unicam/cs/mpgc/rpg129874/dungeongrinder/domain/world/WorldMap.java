package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.creature.BaseCreature;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room.GameRoom;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room.RoomPoint;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room.TileType;

import static it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant.TILE_SIZE;

public class WorldMap implements WorldEnvironment {
    private final long seed;
    private final Player player;
    private final EntityContainer entityContainer;

    private GameRoom currentRoom;
    private TileType[][] currentGrid;

    public WorldMap(long seed) {
        this.seed = seed;
        this.player = new Player();
        this.entityContainer = new WorldEntityContainer();
        entityContainer.getEntities().add(player);
        entityContainer.getEntities().add(new BaseCreature(this, Position.center()));

        this.currentRoom = new GameRoom(this, RoomPoint.zero());
        this.currentGrid = currentRoom.getGrid();
    }

    @Override
    public long getSeed() {
        return seed;
    }

    @Override
    public TileType getTileAt(int x, int y) {
        return currentGrid[x][y];
    }

    @Override
    public boolean isAreaWalkable(int x, int y) {
        if (x < 0 || x + TILE_SIZE > Constant.APP_WIDTH || y < 0 || y + TILE_SIZE > Constant.APP_HEIGHT) {
            return false;
        }
        int tileX1 = x / TILE_SIZE;
        int tileY1 = y / TILE_SIZE;
        int tileX2 = (x + TILE_SIZE - 1) / TILE_SIZE;
        int tileY2 = (y + TILE_SIZE - 1) / TILE_SIZE;

        return getTileAt(tileX1, tileY1).isWalkable() && getTileAt(tileX2, tileY1).isWalkable() && getTileAt(tileX1,
                tileY2).isWalkable() && getTileAt(tileX2, tileY2).isWalkable();
    }

    @Override
    public EntityContainer getEntityContainer() {
        return entityContainer;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public GameRoom getCurrentRoom() {
        return currentRoom;
    }

    @Override
    public void setCurrentRoom(GameRoom room) {
        this.currentRoom = room;
        this.currentGrid = room.getGrid();
    }
}
