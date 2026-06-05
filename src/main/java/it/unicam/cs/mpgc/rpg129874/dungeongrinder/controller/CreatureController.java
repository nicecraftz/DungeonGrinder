package it.unicam.cs.mpgc.rpg129874.dungeongrinder.controller;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.creature.Creature;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.Entity;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.EntityContainer;

import java.util.Set;

public class CreatureController {
    private final EntityContainer container;

    public CreatureController(EntityContainer container) {
        this.container = container;
    }

    public void tickCreatures() {
        Set<Entity> entities = container.getEntities();
        for (Entity entity : entities) {
            if (!(entity instanceof Creature creature)) continue;
            creature.getGoalSelector().tick();
        }
    }
}
