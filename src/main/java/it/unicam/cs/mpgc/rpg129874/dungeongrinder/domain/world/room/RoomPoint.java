package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room;

public record RoomPoint(int x, int y) {

    public static RoomPoint zero() {
        return new RoomPoint(0, 0);
    }
}
