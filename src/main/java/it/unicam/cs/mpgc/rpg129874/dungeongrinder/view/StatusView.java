package it.unicam.cs.mpgc.rpg129874.dungeongrinder.view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.Arrays;

public class StatusView extends VBox {
    private final Label health;
    private final Label experience;

    public StatusView() {
        super(10);
        this.health = new Label();
        this.experience = new Label();

        Arrays.asList(health, experience).forEach(c -> {
            c.setFont(new Font("Arial", 15));
            c.setStyle("-fx-text-fill: #ffffff");
        });

        setStyle("-fx-background-color: transparent; -fx-padding: 10;");
        getChildren().addAll(health, experience);
    }

    public void setHealth(double health, double maxHealth) {
        this.health.setText("Vita: " + health + "/" + maxHealth);
    }

    public void setExperience(int experience) {
        this.experience.setText("Livello: " + experience);
    }
}
