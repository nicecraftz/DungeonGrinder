package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.command.action;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.command.Command;
import javafx.scene.input.KeyCode;

public interface ActionCommand extends Command<KeyCode> {

    void execute();
}
