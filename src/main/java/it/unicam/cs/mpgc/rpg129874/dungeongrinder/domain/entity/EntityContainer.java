package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;

import java.util.HashSet;
import java.util.Set;

public interface EntityContainer {
    Set<Entity> getEntities();

    Player getPlayer();

    default void addEntity(Entity entity) {
        getEntities().add(entity);
    }

    default void removeEntity(Entity entity) {
        getEntities().remove(entity);
    }

    default void removeAllEntities() {
        getEntities().clear();
        getEntities().add(getPlayer());
    }

    default Set<Entity> getNearbyEntities(Position origin, int maxDistance) {
        Set<Entity> nearbyEntities = new HashSet<>();
        for (Entity entity : getEntities()) {
            if (entity.getPosition().distance(origin) < maxDistance) nearbyEntities.add(entity);
        }
        return nearbyEntities;
    }
}
