package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world;

public class GameRoom {
    private final int x;
    private final int y;

    private GameRoom next;
    private GameRoom previous;

    public GameRoom(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isLastRoom() {
        return next == null;
    }

    public boolean isStartingRoom() {
        return previous == null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getGrid() {
        return RoomGenerator.generateRoomGrid(WorldMap.SEED, x, y);
    }
}
