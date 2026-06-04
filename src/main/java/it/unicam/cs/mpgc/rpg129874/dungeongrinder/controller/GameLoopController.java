package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller;

import javafx.animation.AnimationTimer;

public class GameLoopController extends AnimationTimer {
    private static final long FRAMES_PER_SECOND = 60;
    private static final long NANOS_PER_FRAME = 1_000_000_000 / FRAMES_PER_SECOND;
    private final GameController controller;
    private long previousTime;

    public GameLoopController(GameController controller) {
        this.controller = controller;
        start();
    }

    @Override
    public void handle(long now) {
        long timePassed = now - previousTime;
        if (timePassed >= NANOS_PER_FRAME) {
            controller.tick();
            previousTime = now;
        }
    }
}
