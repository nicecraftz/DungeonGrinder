package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.combat;

import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.EntityType;
import it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.LivingEntity;

public class DamageCalculator {

    public static int calculateDamage(LivingEntity attacker, LivingEntity defender) {
        EntityType attackerType = attacker.getType();
        EntityType defenderType = defender.getType();

        if (defenderType == EntityType.PLAYER) return attacker.getStrength();
        return 1;
    }
}
