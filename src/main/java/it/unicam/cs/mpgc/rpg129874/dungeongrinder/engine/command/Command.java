package it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.command;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;

public interface Command<K, T> {
    K key();

    void execute(Player player, T input);
}
