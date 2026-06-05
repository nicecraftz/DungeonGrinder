package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.compound.EntityDescriptor;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder.Vector2D;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.asset.AssetKey;

import java.util.UUID;

public interface Entity {

    UUID getUniqueId();

    EntityDescriptor getDescriptor();

    Position getPosition();

    AssetKey getAssetKey();

    Vector2D getVelocity();

    void setVelocity(Vector2D velocity);

    default void addVelocity(Vector2D vector2D) {
        setVelocity(getVelocity().add(vector2D));
    }

    default int getSpeed() {
        return getDescriptor().attributes().speed();
    }
}
