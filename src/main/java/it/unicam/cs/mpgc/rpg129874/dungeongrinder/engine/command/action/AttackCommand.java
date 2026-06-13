package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.command.action;

import javafx.scene.input.KeyCode;

public class AttackCommand implements ActionCommand {
    @Override
    public void execute() {
    }

    @Override
    public KeyCode key() {
        return KeyCode.SPACE;
    }
}
