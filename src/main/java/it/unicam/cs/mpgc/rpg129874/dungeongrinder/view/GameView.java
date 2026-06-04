package it.unicam.cs.mpgc.rpg129874.dungeongrinder.view;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldEnvironment;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room.TileType;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldMap;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.AssetKey;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.AssetRegistry;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;

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

    public void render(WorldEnvironment environment) {
        Stack<AssetKey> renderStack = new Stack<>();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setImageSmoothing(false);
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int x = 0; x < Constant.MAP_WIDTH; x++) {
            for (int y = 0; y < Constant.MAP_HEIGHT; y++) {
                TileType tileType = environment.getTileAt(x, y);

                switch (tileType) {
                    case WALL -> renderStack.push(AssetKey.ROOM_WALL);
                    case FLOOR, DOOR_LOCK -> renderStack.push(AssetKey.ROOM_FLOOR);
                    case CHEST -> {
                        renderStack.push(AssetKey.CHEST);
                        renderStack.push(AssetKey.ROOM_FLOOR);
                    }
                    case DOOR -> renderStack.push(AssetKey.HOLE);
                    default -> throw new IllegalStateException("Unexpected value: " + tileType);
                }

                while (!renderStack.isEmpty()) {
                    gc.drawImage(ASSET_REGISTRY.getAsset(renderStack.pop()).getDefaultImage(), x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                }
            }
        }

        Position position = environment.getPlayer().getPosition();
        gc.drawImage(ASSET_REGISTRY.getAsset(AssetKey.CHORT_IDLE).getRandom(), position.getX(), position.getY(), TILE_SIZE, TILE_SIZE);
    }

    public DebugOverlayView getDebugOverlay() {
        return debugOverlay;
    }

}
