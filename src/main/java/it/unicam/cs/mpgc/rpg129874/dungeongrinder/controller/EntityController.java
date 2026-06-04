package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.Creature;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.Entity;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.EntityContainer;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder.Pathfinder;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldEnvironment;

import java.util.Set;

public class EntityController {
    private final WorldEnvironment environment;

    public EntityController(WorldEnvironment environment) {
        this.environment = environment;
    }

    public void pathfindEntities() {
        EntityContainer entityContainer = environment.getEntityContainer();
        Set<Entity> entities = entityContainer.getEntities();
        for (Entity entity : entities) {
            if (!(entity instanceof Creature creature)) continue;
            Pathfinder pathfinder = creature.getPathfinder();
            Player player = entityContainer.getPlayer();
            pathfinder.moveToBestPosition(creature.getPosition(), player.getPosition(), creature.getDescriptor().attributes().speed());
        }

    }
}
