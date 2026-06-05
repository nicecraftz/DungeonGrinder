package it.unicam.cs.mpgc.rpg129874.dungeongrinder.view;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.room.TileType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.Arrays;
import java.util.List;

public class DebugOverlayView extends VBox {
    private final Label rawCoordinates = new Label("RawCoordinates: 0,0");
    private final Label coordinatesLabel = new Label("Coordinates: 0,0");
    private final Label roomCoordsLabel = new Label("RoomCoordinates: 0,0");
    private final Label roomSeedLabel = new Label("RoomSeed: 0");
    private final Label currentTile = new Label("Current Tile: ");
    private final Label fpsLabel = new Label("FPS: 0");
    private final Label currentVelocity = new Label("Velocity: ");

    public DebugOverlayView() {
        super(5);
        List<Label> labels = Arrays.asList(rawCoordinates, coordinatesLabel, roomCoordsLabel, roomSeedLabel, fpsLabel, currentTile,
                currentVelocity);
        labels.forEach(c -> {
            c.setFont(new Font("Arial", 15));
            c.setStyle("-fx-text-fill: #ffffff");
        });

        setMouseTransparent(true);
        setStyle("-fx-background-color: transparent; -fx-padding: 10;");
        getChildren().addAll(labels);

        setVisible(false);
    }

    public void setFps(double fps) {
        fpsLabel.setText(String.format("FPS: %.0f", fps));
    }

    public void setRawCoordinates(int x, int y) {
        rawCoordinates.setText("RawCoordinates: " + x + ", " + y);
    }

    public void setCoordinates(int x, int y) {
        coordinatesLabel.setText("Coordinates: " + x + ", " + y);
    }

    public void setRoomCoordinates(int x, int y) {
        roomCoordsLabel.setText("RoomCoordinates: " + x + ", " + y);
    }

    public void setRoomSeed(long roomSeed) {
        roomSeedLabel.setText("RoomSeed: " + roomSeed);
    }

    public void setCurrentTile(TileType tile) {
        currentTile.setText("Current Tile: " + tile.name());
    }

    public void setCurrentVelocity(int x, int y) {
        currentVelocity.setText("Velocity: " + x + ", " + y);
    }
}
