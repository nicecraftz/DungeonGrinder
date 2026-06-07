package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.goal;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.creature.Creature;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player.Player;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder.SimplePathFinder;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder.Vector2D;

public class PlayerChaseGoal implements Goal {
    private static final SimplePathFinder PATH_FINDER = new SimplePathFinder();

    private final Creature creature;
    private final Player target;
    private final int maxTileDistance;

    public PlayerChaseGoal(Creature creature, Player target, int maxTileDistance) {
        this.creature = creature;
        this.target = target;
        this.maxTileDistance = maxTileDistance;
    }

    @Override
    public boolean canStart() {
        double distance = creature.getPosition().distanceTiled(target.getPosition());
        return distance <= maxTileDistance;
    }

    @Override
    public boolean canContinue() {
        double distance = creature.getPosition().distanceTiled(target.getPosition());
        return distance <= maxTileDistance;
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
