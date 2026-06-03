package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.Position;

import java.util.UUID;

public interface Entity {

    UUID getUniqueId();

    int getMaxHealth();

    int getHealth();

    void setHealth(int newHealth);

    boolean isDead();

    String getName();

    Position getPosition();
}
