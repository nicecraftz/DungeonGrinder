package it.unicam.cs.mpgc.rpg129874.dungeongrinder.view;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.Constant;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class TransitionOverlayView extends Region {
    private final Rectangle overlay;

    public TransitionOverlayView() {
        this.overlay = new Rectangle(Constant.APP_WIDTH, Constant.APP_HEIGHT, Color.BLACK);
        this.overlay.setOpacity(0);
        this.overlay.setMouseTransparent(true);
        getChildren().add(overlay);
        setMouseTransparent(true);
    }

    public void startBlink(Runnable onMidPoint) {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(300), overlay);
        fadeOut.setFromValue(0);
        fadeOut.setToValue(1);
        fadeOut.setOnFinished(e -> onMidPoint.run());

        FadeTransition fadeIn = new FadeTransition(Duration.millis(300), overlay);
        fadeIn.setFromValue(1);
        fadeIn.setToValue(0);

        SequentialTransition sequence = new SequentialTransition(fadeOut, fadeIn);
        sequence.play();
    }
}
