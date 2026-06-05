package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.command.movement;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.Entity;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.command.Command;
import javafx.scene.input.KeyCode;

public interface MovementCommand extends Command<KeyCode> {
    void execute(Entity entity);

}
