package it.unicam.cs.mpgc.rpg129874.dungeongrinder.view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.Arrays;

public class DebugOverlayView extends VBox {
    private final Label coordinates = new Label("Coordinates: 0,0");
    private final Label drawCount = new Label("Draw count: 0");

    public DebugOverlayView() {
        super(5);
        Arrays.asList(coordinates, drawCount).forEach(c -> {
            c.setFont(new Font("Arial", 15));
            c.setStyle("-fx-text-fill: #ffffff");
        });

        setMouseTransparent(true);
        setStyle("-fx-background-color: transparent; -fx-padding: 10;");

        getChildren().addAll(coordinates, drawCount);
        setVisible(false);
    }

    public void setCoordinates(double x, double y) {
        coordinates.setText("Coordinates: " + x + ", " + y);
    }

    public void setDrawCount(int count) {
        drawCount.setText("Draw count: " + count);
    }
}
