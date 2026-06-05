package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.goal;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.creature.Creature;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;

import java.util.concurrent.TimeUnit;

public class PlayerAttackGoal implements Goal {
    private static final long TIME_BETWEEN_ATTACK_MILLIS = TimeUnit.SECONDS.toMillis(1);
    private final Creature creature;
    private final Player target;
    private long lastAttackTime = 0;

    public PlayerAttackGoal(Creature creature, Player target) {
        this.creature = creature;
        this.target = target;
    }


    private boolean canAttack() {
        return System.currentTimeMillis() - lastAttackTime >= TIME_BETWEEN_ATTACK_MILLIS;
    }

    @Override
    public boolean canStart() {
        return creature.getPosition().distance(target.getPosition()) <= 1 && canAttack();
    }

    @Override
    public boolean canContinue() {
        return creature.getPosition().distance(target.getPosition()) <= 1 && canAttack();
    }

    @Override
    public void start() {
        System.out.println("Starting attack animation");
    }

    @Override
    public void tick() {
        System.out.println("Attacking on player");
        lastAttackTime = System.currentTimeMillis();
    }

    @Override
    public void stop() {
        System.out.println("Stopping attack animation");
    }
}
