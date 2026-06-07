package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.creature;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.LivingEntity;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.compound.EntityDescriptor;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.goal.GoalSelector;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;

public abstract class Creature extends LivingEntity {
    private final GoalSelector goalSelector;

    public Creature(EntityDescriptor descriptor, Position position) {
        super(descriptor, position);
        goalSelector = new GoalSelector();
    }

    public GoalSelector getGoalSelector() {
        return goalSelector;
    }
}
