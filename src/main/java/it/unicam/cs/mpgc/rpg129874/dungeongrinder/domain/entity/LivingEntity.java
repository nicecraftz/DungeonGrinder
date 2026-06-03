package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.Position;

import java.util.UUID;

public abstract class LivingEntity implements Entity, RenderEntity {
    private final UUID uuid;
    private int health;
    private final int maxHealth;
    private boolean dead = false;
    private final Position position;

    public LivingEntity(int maxHealth, Position position) {
        this.position = position;
        this.uuid = UUID.randomUUID();
        this.health = maxHealth;
        this.maxHealth = maxHealth;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public void setHealth(int newHealth) {
        health = Math.max(0, Math.min(maxHealth, newHealth));
        if (health == 0) dead = true;
    }

    @Override
    public boolean isDead() {
        return dead;
    }

    @Override
    public UUID getUniqueId() {
        return uuid;
    }

    public abstract EntityType getType();

    public abstract int getStrength();

    @Override
    public Position getPosition() {
        return position;
    }
}
