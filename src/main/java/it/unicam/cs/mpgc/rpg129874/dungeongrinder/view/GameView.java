package it.unicam.cs.mpgc.rpg129874.dungeongrinder.view;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.Entity;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.LivingEntity;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldEnvironment;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room.TileType;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.AssetKey;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.AssetRegistry;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;

import java.util.Set;

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

    private void render(GraphicsContext gc, AssetKey assetKey, int x, int y) {
        gc.drawImage(ASSET_REGISTRY.getAsset(assetKey).getDefaultImage(), x, y, TILE_SIZE, TILE_SIZE);
    }

    private void renderTile(GraphicsContext gc, AssetKey assetKey, int x, int y) {
        render(gc, assetKey, x * TILE_SIZE, y * TILE_SIZE);
    }

    public void render(WorldEnvironment environment) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setImageSmoothing(false);

        for (int x = 0; x < Constant.MAP_WIDTH; x++) {
            for (int y = 0; y < Constant.MAP_HEIGHT; y++) {
                TileType tileType = environment.getTileAt(x, y);
                if (tileType == TileType.CHEST) renderTile(gc, AssetKey.ROOM_FLOOR, x, y);
                renderTile(gc, tileType.getAssetKey(), x, y);
            }
        }

        Set<Entity> entities = environment.getEntityContainer().getEntities();
        for (Entity entity : entities) {
            if (!(entity instanceof LivingEntity livingEntity)) continue;
            Position position = livingEntity.getPosition();
            render(gc, livingEntity.getAssetKey(), position.getX(), position.getY());
        }

        Position position = environment.getPlayer().getPosition();
        render(gc, AssetKey.DOC_IDLE, position.getX(), position.getY() - 5);
    }

    public DebugOverlayView getDebugOverlay() {
        return debugOverlay;
    }

    public void toggleDebugOverlay() {
        debugOverlay.setVisible(!debugOverlay.isVisible());
    }

}
