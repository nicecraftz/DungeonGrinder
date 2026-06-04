package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldEnvironment;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Point;

import java.util.Random;

public class GameRoom {
    private final Point point;
    private final long seed;
    private final RoomAttributes roomAttributes;

    public GameRoom(WorldEnvironment environment, Point point) {
        this.point = point;
        this.seed = environment.getSeed() ^ (point.x() * 23099561L) ^ (point.y() * 34555567L);
        this.roomAttributes = new RoomAttributes(seed);
    }

    public Point getPoint() {
        return point;
    }

    public TileType[][] getGrid() {
        return RoomGenerator.generateRoomGrid(new Random(getSeed()), roomAttributes);
    }

    public long getSeed() {
        return seed;
    }

    public RoomAttributes getRoomAttributes() {
        return roomAttributes;
    }
}
