package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.pathfinder;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;

public interface Pathfinder {

    Vector2D calculateMovement(Position origin, Position target, int stepSpeed);
}
