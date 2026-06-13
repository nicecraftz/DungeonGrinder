package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.view.StatusView;

public class StatusController {
    private final StatusView view;

    public StatusController(StatusView view) {
        this.view = view;
    }

    public void update(Player player) {
        view.setHealth(player.getHealth(), player.getDescriptor().attributes().maxHealth());
        view.setExperience(player.getExperience());
    }
}
