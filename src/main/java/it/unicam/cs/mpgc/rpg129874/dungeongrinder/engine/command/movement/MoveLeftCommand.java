package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.command.movement;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.Entity;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Direction;
import javafx.scene.input.KeyCode;

public class MoveLeftCommand implements MovementCommand {
    @Override
    public KeyCode key() {
        return KeyCode.A;
    }

    @Override
    public void execute(Entity entity) {
        entity.addVelocity(Direction.LEFT.toVectorWithSpeed(entity.getSpeed()));
    }
}
