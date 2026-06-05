package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.LivingEntity;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.compound.EntityDescriptor;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.asset.AssetKey;

public abstract class HumanEntity extends LivingEntity {
    private int level;
    private int experience;

    public HumanEntity(EntityDescriptor descriptor, Position position) {
        super(descriptor, position);
    }

    public void addExperience(int gainedExperience) {
        experience += gainedExperience;
        if (experience >= 100) {
            experience = experience % 100;
            level++;
        }
    }

    @Override
    public AssetKey getAssetKey() {
        return AssetKey.DOC_IDLE;
    }

    public int getLevel() {
        return level;
    }
}
