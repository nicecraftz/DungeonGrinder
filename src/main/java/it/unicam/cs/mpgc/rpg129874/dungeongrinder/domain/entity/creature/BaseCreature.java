package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.creature;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.compound.EntityAttributes;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.compound.EntityDescriptor;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.goal.PlayerAttackGoal;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.goal.PlayerChaseGoal;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldEnvironment;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.asset.AssetKey;

public class BaseCreature extends Creature {
    private static final EntityAttributes ENTITY_ATTRIBUTES = new EntityAttributes(100, 2, 3);
    private static final EntityDescriptor ENTITY_DESCRIPTOR = new EntityDescriptor("Prova", ENTITY_ATTRIBUTES);

    public BaseCreature(WorldEnvironment worldEnvironment, Position position) {
        super(ENTITY_DESCRIPTOR, position);
        getGoalSelector().addGoal(new PlayerChaseGoal(this, worldEnvironment.getPlayer(), 3), 1);
        getGoalSelector().addGoal(new PlayerAttackGoal(this, worldEnvironment.getPlayer()), 2);
    }

    @Override
    protected double calculateDamage(double originalDamage) {
        return 0;
    }

    @Override
    public AssetKey getAssetKey() {
        return AssetKey.CHORT_IDLE;
    }
}
