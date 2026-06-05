package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.goal;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.creature.Creature;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder.SimplePathFinder;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder.Vector2D;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.engine.physics.MovementSystem;

public class PlayerChaseGoal implements Goal {
    private static final SimplePathFinder PATH_FINDER = new SimplePathFinder();

    private final Creature creature;
    private final Player target;

    public PlayerChaseGoal(Creature creature, Player target) {
        this.creature = creature;
        this.target = target;
    }

    @Override
    public boolean canStart() {
        double distance = creature.getPosition().distance(target.getPosition());
        return distance <= creature.getLockDistance();
    }

    @Override
    public boolean canContinue() {
        double distance = creature.getPosition().distance(target.getPosition());
        return distance <= creature.getLockDistance();
    }

    @Override
    public void start() {
    }

    @Override
    public void tick() {
        Vector2D moveVector = PATH_FINDER.calculateMovement(creature.getPosition(),
                target.getPosition(),
                creature.getSpeed());
        creature.addVelocity(moveVector);
    }

    @Override
    public void stop() {

    }
}
