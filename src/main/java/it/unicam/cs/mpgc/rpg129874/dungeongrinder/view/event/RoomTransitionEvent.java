package it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.event;

import javafx.event.Event;
import javafx.event.EventType;

public class RoomTransitionEvent extends Event {
    public static final EventType<RoomTransitionEvent> TRANSITION_REQUESTED =
            new EventType<>(Event.ANY, "TRANSITION_REQUESTED");

    private final Runnable onMidPoint;

    public RoomTransitionEvent(Runnable onMidPoint) {
        super(TRANSITION_REQUESTED);
        this.onMidPoint = onMidPoint;
    }

    public void executeCallback() {
        if (onMidPoint != null) {
            onMidPoint.run();
        }
    }
}
