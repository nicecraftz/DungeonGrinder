package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.player;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.compound.EntityAttributes;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.compound.EntityDescriptor;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.world.position.Position;

public class Player extends HumanEntity {
    public static final EntityAttributes PLAYER_ATTRIBUTES = new EntityAttributes(100, 4, 3);
    public static final EntityDescriptor PLAYER_DESCRIPTOR = new EntityDescriptor("Giocatore", PLAYER_ATTRIBUTES);

    public Player() {
        super(PLAYER_DESCRIPTOR, Position.center());
    }

    @Override
    protected double calculateDamage(double originalDamage) {
        return 0;
    }
}
