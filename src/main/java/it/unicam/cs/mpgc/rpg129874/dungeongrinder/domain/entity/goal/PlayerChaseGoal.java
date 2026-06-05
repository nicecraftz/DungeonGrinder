package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.goal;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.Creature;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.physics.MovementSystem;

public class PlayerChaseGoal implements Goal {
    private final Creature creature;
    private final Player target;
    private final MovementSystem movementSystem;

    public PlayerChaseGoal(Creature creature, Player target, MovementSystem movementSystem) {
        this.creature = creature;
        this.target = target;
        this.movementSystem = movementSystem;
    }

    @Override
    public boolean canStart() {
        return false;
    }

    @Override
    public boolean canContinue() {
        return false;
    }

    @Override
    public void start() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void stop() {

    }
}
