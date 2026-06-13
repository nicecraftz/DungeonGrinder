package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.command.movement.*;
import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MovementInputController {
    private final Map<KeyCode, MovementCommand> commands;

    public MovementInputController() {
        this.commands = new HashMap<>();
        configureMovementCommands();
    }

    private void configureMovementCommands() {
        registerMovementCommand(new MoveDownCommand());
        registerMovementCommand(new MoveUpCommand());
        registerMovementCommand(new MoveLeftCommand());
        registerMovementCommand(new MoveRightCommand());
    }

    private void registerMovementCommand(MovementCommand command) {
        commands.put(command.key(), command);
    }

    public void process(Set<KeyCode> keys, Player player) {
        for (KeyCode key : keys) {
            MovementCommand movementCommand = commands.get(key);
            if (movementCommand == null) continue;
            movementCommand.execute(player);
        }
    }
}
