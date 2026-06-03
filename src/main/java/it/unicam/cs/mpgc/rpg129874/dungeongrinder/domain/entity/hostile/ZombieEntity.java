package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.hostile;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.Position;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.assets.AssetKey;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.EntityType;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.LivingEntity;

public class ZombieEntity extends LivingEntity {
    private static final int MAX_HP = 20, STRENGTH = 2;

    public ZombieEntity(Position position) {
        super(MAX_HP, position);
    }

    @Override
    public String getName() {
        return "Zombie";
    }

    @Override
    public EntityType getType() {
        return EntityType.UNDEAD;
    }

    @Override
    public int getStrength() {
        return STRENGTH;
    }

    @Override
    public AssetKey getKey() {
        return AssetKey.ZOMBIE;
    }
}
