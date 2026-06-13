package it.unicam.cs.mpgc.rpg129874.dungeongrinder.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class StartMenuView extends VBox {
    private final TextField seedField;
    private final Button startButton;

    public StartMenuView() {
        super(15);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #2c3e50; -fx-padding: 40; -fx-border-color: #34495e; -fx-border-width: 5;");

        Label titleLabel = new Label("DUNGEON GRINDER");
        titleLabel.setStyle("-fx-text-fill: #ecf0f1; -fx-font-size: 24px; -fx-font-weight: bold;");

        seedField = new TextField();
        seedField.setPromptText("Inserisci seed (opzionale)");
        seedField.setMaxWidth(250);

        startButton = new Button("AVVIA");
        startButton.setStyle(
                "-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand;");

        startButton.setOnMouseEntered(e -> startButton.setStyle(
                "-fx-background-color: #2ecc71; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand;"));
        startButton.setOnMouseExited(e -> startButton.setStyle(
                "-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold; -fx-cursor: hand;"));

        this.getChildren().addAll(titleLabel, seedField, startButton);
    }

    public Button getStartButton() {
        return startButton;
    }

    public String getSeed() {
        return seedField.getText();
    }
}