package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.StartMenuView;

import java.util.function.Consumer;

public class StartMenuController {
    private final StartMenuView view;
    private final Consumer<Long> seededNotification;

    public StartMenuController(StartMenuView view, Consumer<Long> seededNotification) {
        this.view = view;
        this.seededNotification = seededNotification;
        view.getStartButton().setOnAction(event -> handleStart());
    }

    private void handleStart() {
        String seedText = view.getSeed();
        long seed = seedText == null || seedText.isEmpty() ? System.currentTimeMillis() : seedText.hashCode();
        seededNotification.accept(seed);
    }
}
