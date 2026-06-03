package it.unicam.cs.mpgc.rpg129874.dungeongrinder.view;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldMap;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import static it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant.TILE_SIZE;


public class WorldMapView extends Pane {
    private final Canvas canvas;

    public WorldMapView() {
        this.canvas = new Canvas();
        getChildren().add(canvas);
    }

    public void render(WorldMap map) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int[][] grid = map.getGrid();
        System.out.println("Drawing Grid");

        for (int x = 0; x < map.getGrid().length; x++) {
            for (int y = 0; y < map.getGrid()[0].length; y++) {
                int cellType = grid[x][y];
                switch (cellType) {
                    case 1 -> gc.setFill(Color.RED);
                    case 2 -> gc.setFill(Color.GREEN);
                    case 3 -> gc.setFill(Color.BLUE);
                    case 4 -> gc.setFill(Color.YELLOW);
                    case 5 -> gc.setFill(Color.CYAN);
                }
                gc.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }

}
