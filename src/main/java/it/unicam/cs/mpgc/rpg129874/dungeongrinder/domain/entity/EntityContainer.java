package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;

import java.util.Set;

public interface EntityContainer {

    void addEntity(Entity entity);

    void removeEntity(Entity entity);

    void removeAllEntities();

    Set<Entity> getEntities();

    Player getPlayer();
}
