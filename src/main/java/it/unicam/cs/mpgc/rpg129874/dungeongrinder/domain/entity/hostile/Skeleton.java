package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.hostile;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.Creature;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.EntityAttributes;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.EntityDescriptor;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder.Pathfinder;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder.SimplePathFinder;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.AssetKey;

public class Skeleton extends Creature {
    private static final EntityAttributes SKELETON_ATTRIBUTES = new EntityAttributes(50, 3, 2);
    private static final EntityDescriptor SKELETON_DESCRIPTOR = new EntityDescriptor("Skeleton", SKELETON_ATTRIBUTES);
    private final SimplePathFinder simplePathFinder;

    public Skeleton() {
        super(SKELETON_DESCRIPTOR, Position.center());
        simplePathFinder = new SimplePathFinder();
    }

    @Override
    protected double calculateDamage(double originalDamage) {
        return 0;
    }

    @Override
    public AssetKey getAssetKey() {
        return AssetKey.CHORT_IDLE;
    }

    @Override
    public Pathfinder getPathfinder() {
        return simplePathFinder;
    }
}
