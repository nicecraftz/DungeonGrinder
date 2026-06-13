package it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.event;

import javafx.event.Event;
import javafx.event.EventType;

public class RoomTransitionEvent extends Event {
    public static final EventType<RoomTransitionEvent> TRANSITION_REQUESTED =
            new EventType<>(Event.ANY, "TRANSITION_REQUESTED");

    private final Runnable onMidPoint;
    private final Runnable onEnd;

    public RoomTransitionEvent(Runnable onMidPoint, Runnable onEnd) {
        super(TRANSITION_REQUESTED);
        this.onMidPoint = onMidPoint;
        this.onEnd = onEnd;
    }

    public void executeMidPointCallback() {
        if (onMidPoint != null) {
            onMidPoint.run();
        }
    }

    public void executeEndCallback() {
        if (onEnd != null) {
            onEnd.run();
        }
    }
}
