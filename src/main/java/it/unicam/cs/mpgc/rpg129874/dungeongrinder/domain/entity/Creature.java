package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder.Pathfinder;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;

public abstract class Creature extends LivingEntity {
    protected Creature(EntityDescriptor descriptor, Position position) {
        super(descriptor, position);
    }

    public abstract Pathfinder getPathfinder();
}
