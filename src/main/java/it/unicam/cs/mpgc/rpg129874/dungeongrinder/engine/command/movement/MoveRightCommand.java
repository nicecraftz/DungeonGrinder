package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.command.movement;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.Entity;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Direction;
import javafx.scene.input.KeyCode;

public class MoveRightCommand implements MovementCommand {
    @Override
    public KeyCode key() {
        return KeyCode.D;
    }

    @Override
    public void execute(Entity entity) {
        entity.addVelocity(Direction.RIGHT.toVectorWithSpeed(entity.getSpeed()));
    }
}
