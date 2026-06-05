package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.Entity;

import java.util.Set;

public interface EntityContainer {
    Set<Entity> getEntities();
}