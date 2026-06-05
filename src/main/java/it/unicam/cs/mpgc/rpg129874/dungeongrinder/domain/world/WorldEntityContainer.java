package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.Entity;

import java.util.HashSet;
import java.util.Set;

public class WorldEntityContainer implements EntityContainer {
    private final Set<Entity> entities;

    public WorldEntityContainer() {
        this.entities = new HashSet<>();
    }

    @Override
    public Set<Entity> getEntities() {
        return entities;
    }

}
