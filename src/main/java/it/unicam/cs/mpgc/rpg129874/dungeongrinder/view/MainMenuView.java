package it.unicam.cs.mpgc.rpg129874.dungeongrinder.view;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.DungeonGrinderApplication;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMenuView extends VBox {
    private final Stage primaryStage;

    public MainMenuView(Stage primaryStage) {
        super(0);
        this.primaryStage = primaryStage;
        initMenu();
    }

    private void initMenu() {
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: #1a1a1a;");

        Label title = new Label(DungeonGrinderApplication.APPLICATION_NAME);
        title.setStyle("-fx-text-fill: #ffaa11;");
        title.setFont(new Font("Impact", 64));

        Button playButton = new Button("GIOCA");
        playButton.setStyle("-fx-background-color: none;" + "-fx-text-fill: #ffffff;");
        playButton.setFont(new Font("Impact", 32));
        playButton.setOnAction(e -> switchToGame());

        getChildren().addAll(title, playButton);
    }

    private void switchToGame() {
        Scene mainMenuScene = this.getScene();
        GameView gameView = new GameView(primaryStage, mainMenuScene);
        Scene gameScene = new Scene(gameView, mainMenuScene.getWidth(), mainMenuScene.getHeight());
        primaryStage.setScene(gameScene);
    }
}
