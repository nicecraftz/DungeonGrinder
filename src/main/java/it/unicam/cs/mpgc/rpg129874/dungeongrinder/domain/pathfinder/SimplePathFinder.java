package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;

public class SimplePathFinder implements Pathfinder {

    @Override
    public void moveToBestPosition(Position origin, Position target, int stepSpeed) {
        int currentX = origin.getX();
        int currentY = origin.getY();
        int targetX = target.getX();
        int targetY = target.getY();

        double totalDistance = origin.distance(target);
        if (totalDistance <= stepSpeed) {
            origin.setX(targetX);
            origin.setY(targetY);
        }

        double ratio = stepSpeed / totalDistance;
        int nextX = currentX + (int) Math.round((targetX - currentX) * ratio);
        int nextY = currentY + (int) Math.round((targetY - currentY) * ratio);

        origin.setX(nextX);
        origin.setY(nextY);
    }
}
