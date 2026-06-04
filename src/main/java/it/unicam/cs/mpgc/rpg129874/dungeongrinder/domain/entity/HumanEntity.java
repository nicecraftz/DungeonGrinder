package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.AssetKey;

public abstract class HumanEntity extends LivingEntity {
    private int level;
    private int experience;
    private final int speed;

    public HumanEntity(EntityDescriptor descriptor, Position position) {
        super(descriptor, position);
        speed = descriptor.attributes().speed();
    }

    public void moveForward() {
        getPosition().setY(getPosition().getY() - speed);
    }

    public void moveBackwards() {
        getPosition().setY(getPosition().getY() + speed);
    }

    public void moveLeft() {
        getPosition().setX(getPosition().getX() - speed);
    }

    public void moveRight() {
        getPosition().setX(getPosition().getX() + speed);
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
