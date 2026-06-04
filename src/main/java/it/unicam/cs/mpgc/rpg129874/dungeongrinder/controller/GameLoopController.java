package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller;

import javafx.animation.AnimationTimer;

public class GameLoopController extends AnimationTimer {
    private static final long FRAMES_PER_SECOND = 240;
    private static final long ONE_SECOND = 1_000_000_000L;
    private static final long NANOS_PER_FRAME = ONE_SECOND / FRAMES_PER_SECOND;

    private final GameController controller;
    private long previousTime;
    private long lastFpsUpdateTime;
    private int frameCount;
    private double currentFps;

    public GameLoopController(GameController controller) {
        this.controller = controller;
        start();
    }

    @Override
    public void handle(long now) {
        frameCount++;

        if (now - lastFpsUpdateTime >= ONE_SECOND) {
            currentFps = frameCount;
            frameCount = 0;
            lastFpsUpdateTime = now;
        }

        long timePassed = now - previousTime;
        if (timePassed >= NANOS_PER_FRAME) {
            controller.tick(currentFps);
            previousTime = now;
        }
    }
}
