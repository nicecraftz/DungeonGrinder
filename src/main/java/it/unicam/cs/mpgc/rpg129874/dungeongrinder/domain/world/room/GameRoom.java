package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldEnvironment;

public class GameRoom {
    private final RoomPoint roomPoint;
    private final long seed;
    private final RoomAttributes roomAttributes;

    public GameRoom(WorldEnvironment environment, RoomPoint roomPoint) {
        this.roomPoint = roomPoint;
        this.seed = environment.getSeed() ^ (roomPoint.x() * 23099561L) ^ (roomPoint.y() * 34555567L);
        this.roomAttributes = new RoomAttributes(seed);
    }

    public RoomPoint getPoint() {
        return roomPoint;
    }

    public TileType[][] getGrid() {
        return RoomGenerator.generateRoomGrid(seed, roomAttributes);
    }

    public long getSeed() {
        return seed;
    }

    public RoomAttributes getRoomAttributes() {
        return roomAttributes;
    }
}
