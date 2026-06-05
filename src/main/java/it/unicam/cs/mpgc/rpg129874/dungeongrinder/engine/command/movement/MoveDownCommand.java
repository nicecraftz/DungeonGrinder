package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.command.movement;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.Entity;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Direction;
import javafx.scene.input.KeyCode;

public class MoveDownCommand implements MovementCommand {

    @Override
    public KeyCode key() {
        return KeyCode.S;
    }

    @Override
    public void execute(Entity entity) {
        entity.addVelocity(Direction.DOWN.toVectorWithSpeed(entity.getSpeed()));
    }
}
