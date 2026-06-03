package it.unicam.cs.mpgc.rpg129874.dungeongrinder.view;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldMap;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.assets.AssetKey;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.assets.AssetRegistry;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import static it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant.TILE_SIZE;


public class GameView extends StackPane {
    private static final AssetRegistry ASSET_REGISTRY = AssetRegistry.getInstance();
    private final DebugOverlayView debugOverlay;
    private final Canvas canvas;

    public GameView() {
        this.canvas = new Canvas(Constant.APP_WIDTH, Constant.APP_HEIGHT);
        this.debugOverlay = new DebugOverlayView();
        getChildren().addAll(canvas, debugOverlay);
    }

    public void render(WorldMap map) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int[][] grid = map.getGrid();
        for (int x = 0; x < map.getGrid().length; x++) {
            for (int y = 0; y < map.getGrid()[0].length; y++) {
                int cellType = grid[x][y];
                AssetKey assetKey = null;
                switch (cellType) {
                    case 1 -> assetKey = AssetKey.ROOM_WALL;
                    case 2 -> assetKey = AssetKey.ROOM_FLOOR;
                    case 3 -> gc.setFill(Color.BLUE);
                    case 4 -> gc.setFill(Color.YELLOW);
                    case 5 -> gc.setFill(Color.CYAN);
                    default -> throw new IllegalStateException("Unexpected value: " + cellType);
                }

                if (assetKey != null) {
                    gc.drawImage(ASSET_REGISTRY.getAsset(assetKey), x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                    continue;
                }

                gc.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    public void toggleDebugOverlay() {
        debugOverlay.setVisible(!debugOverlay.isVisible());
    }

}
