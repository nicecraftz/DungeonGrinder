package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world;

public class WorldMap {
    public static final long SEED = 0xcaffeL;
    private GameRoom gameRoom = new GameRoom(0, 0);
    private int[][] grid = gameRoom.getGrid();

    public void setGameRoom(GameRoom gameRoom) {
        this.gameRoom = gameRoom;
        this.grid = gameRoom.getGrid();
    }

    public int[][] getGrid() {
        return grid;
    }
}
