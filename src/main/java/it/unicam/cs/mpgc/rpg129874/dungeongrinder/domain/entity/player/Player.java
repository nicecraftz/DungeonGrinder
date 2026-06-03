package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.EntityAttributes;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.EntityDescriptor;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.HumanEntity;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.Position;

public class Player extends HumanEntity {
    public static final EntityAttributes PLAYER_ATTRIBUTES = new EntityAttributes(100, 5, 3);
    public static final EntityDescriptor PLAYER_DESCRIPTOR = new EntityDescriptor("Giocatore", PLAYER_ATTRIBUTES);

    public Player() {
        super(PLAYER_DESCRIPTOR, Position.CENTER);
    }

    @Override
    protected double calculateDamage(double originalDamage) {
        return 0;
    }
}
