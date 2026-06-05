package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.goal;

public interface Goal {
    boolean canStart();

    boolean canContinue();

    void start();

    void tick();

    void stop();
}
