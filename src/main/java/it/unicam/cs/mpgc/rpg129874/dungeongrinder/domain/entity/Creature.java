package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.goal.GoalSelector;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.WorldEnvironment;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;

public abstract class Creature extends LivingEntity {
    private final int lockDistance;
    private final GoalSelector goalSelector;

    public Creature(EntityDescriptor descriptor, Position position, int lockDistance) {
        super(descriptor, position);
        this.lockDistance = lockDistance;
        goalSelector = new GoalSelector();
    }

    public int getLockDistance() {
        return lockDistance;
    }

    public GoalSelector getGoalSelector() {
        return goalSelector;
    }
}
