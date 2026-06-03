package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity;

import java.util.UUID;

public interface Entity {

    UUID getUniqueId();

    EntityDescriptor getDescriptor();

}
