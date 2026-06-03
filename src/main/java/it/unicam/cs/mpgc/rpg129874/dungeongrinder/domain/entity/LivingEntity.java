package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.Position;

import java.util.UUID;

public abstract class LivingEntity implements Entity, Positionable {
    private final UUID uuid;
    private final EntityDescriptor descriptor;
    private final Position position;
    private double health;


    protected LivingEntity(EntityDescriptor descriptor, Position position) {
        this.uuid = UUID.randomUUID();
        this.descriptor = descriptor;
        this.health = descriptor.attributes().maxHealth();
        this.position = position;
    }

    public double getHealth() {
        return health;
    }

    protected abstract double calculateDamage(double originalDamage);

    public void damage(double originalDamage) {
        double calculated = calculateDamage(originalDamage);
        health = Math.max(0, health - calculated);
    }

    public boolean isDead() {
        return health <= 0;
    }

    @Override
    public EntityDescriptor getDescriptor() {
        return descriptor;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public UUID getUniqueId() {
        return uuid;
    }
}
