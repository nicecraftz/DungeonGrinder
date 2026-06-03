package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.Position;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.assets.AssetKey;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.EntityType;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.LivingEntity;

public class Player extends LivingEntity {

    public Player(int maxHealth, Position position) {
        super(maxHealth, position);
    }

    @Override
    public EntityType getType() {
        return EntityType.PLAYER;
    }

    @Override
    public int getStrength() {
        return 2;
    }

    @Override
    public String getName() {
        return "Giocatore";
    }

    @Override
    public AssetKey getKey() {
        return AssetKey.ZOMBIE;
    }
}
