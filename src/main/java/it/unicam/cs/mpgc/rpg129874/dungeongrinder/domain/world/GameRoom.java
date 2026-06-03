package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world;

public class GameRoom {
    private final int x;
    private final int y;
    private final long roomSeed;

    private GameRoom next;
    private GameRoom previous;

    private boolean completed;

    public GameRoom(int x, int y) {
        this.x = x;
        this.y = y;
        this.roomSeed = WorldMap.SEED ^ (x * 23099561L) ^ (y * 34555567L);
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

    public long getRoomSeed() {
        return roomSeed;
    }

    public void setNext(GameRoom next) {
        this.next = next;
    }

    public void setPrevious(GameRoom previous) {
        this.previous = previous;
    }

    public int[][] getGrid() {
        return RoomGenerator.generateRoomGrid(roomSeed);
    }
}
