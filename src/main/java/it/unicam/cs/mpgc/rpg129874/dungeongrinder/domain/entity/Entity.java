package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.AssetKey;

import java.util.UUID;

public interface Entity {

    UUID getUniqueId();

    EntityDescriptor getDescriptor();

    Position getPosition();

    AssetKey getAssetKey();
}
