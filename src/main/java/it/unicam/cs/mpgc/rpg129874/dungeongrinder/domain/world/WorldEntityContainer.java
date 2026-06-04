package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.Entity;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.EntityContainer;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;

import java.util.HashSet;
import java.util.Set;

public class WorldEntityContainer implements EntityContainer {
    private final Player player;
    private final Set<Entity> entities;

    public WorldEntityContainer(Player player) {
        this.player = player;
        this.entities = new HashSet<>();
    }

    @Override
    public Set<Entity> getEntities() {
        return entities;
    }

    @Override
    public Player getPlayer() {
        return player;
    }
}
