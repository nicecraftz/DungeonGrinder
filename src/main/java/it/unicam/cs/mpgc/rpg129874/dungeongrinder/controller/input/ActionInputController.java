package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller.input;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.command.action.ActionCommand;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.command.action.AttackCommand;
import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ActionInputController {
    private final Map<KeyCode, ActionCommand> commands;

    public ActionInputController() {
        this.commands = new HashMap<>();
        configureMovementCommands();
    }

    private void configureMovementCommands() {
        registerMovementCommand(new AttackCommand());
    }

    private void registerMovementCommand(AttackCommand command) {
        commands.put(command.key(), command);
    }

    public void process(Set<KeyCode> keys, Player player) {
        for (KeyCode key : keys) {
            ActionCommand actionCommand = commands.get(key);
            if (actionCommand == null) continue;
            actionCommand.execute();
        }
    }
}
