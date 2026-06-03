package it.unicam.cs.mpgc.rpg129874.dungeongrinder.view;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.Positionable;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.Position;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.RoomGenerator;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldMap;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.AssetKey;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.AssetRegistry;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.Stack;

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

    public void render(WorldMap map, Positionable positionable) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setImageSmoothing(false);
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int[][] grid = map.getGrid();
        for (int x = 0; x < map.getGrid().length; x++) {
            for (int y = 0; y < map.getGrid()[0].length; y++) {
                int cellType = grid[x][y];
                Stack<AssetKey> keyStack = new Stack<>();
                switch (cellType) {
                    case RoomGenerator.ROOM_WALL -> keyStack.push(AssetKey.ROOM_WALL);
                    case RoomGenerator.ROOM_FLOOR,
                         RoomGenerator.ROOM_DOOR_LOCK -> keyStack.push(AssetKey.ROOM_FLOOR);
                    case RoomGenerator.CHEST -> {
                        keyStack.push(AssetKey.CHEST);
                        keyStack.push(AssetKey.ROOM_FLOOR);
                    }
                    case RoomGenerator.ROOM_DOOR -> keyStack.push(AssetKey.HOLE);
                    default -> throw new IllegalStateException("Unexpected value: " + cellType);
                }

                while (!keyStack.isEmpty()) {
                    gc.drawImage(ASSET_REGISTRY.getAsset(keyStack.pop()).getDefaultImage(), x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                }
            }
        }

        Position position = positionable.getPosition();
        gc.drawImage(ASSET_REGISTRY.getAsset(AssetKey.CHORT_IDLE).getRandom(), position.getX(), position.getY(), TILE_SIZE, TILE_SIZE);
    }

    public DebugOverlayView getDebugOverlay() {
        return debugOverlay;
    }

}
