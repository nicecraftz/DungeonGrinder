package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.command.movement;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Direction;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.physics.MovementSystem;
import javafx.scene.input.KeyCode;

public class MoveRightCommand implements MovementCommand {
    @Override
    public KeyCode key() {
        return KeyCode.D;
    }

    @Override
    public void execute(Player player, MovementSystem input) {
        input.tryMove(player, Direction.RIGHT);
    }
}
