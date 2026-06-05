package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.goal;

import java.util.ArrayList;

public class GoalSelector {
    private final ArrayList<WeightedGoal> goals;
    private Goal activeGoal;

    public GoalSelector() {
        this.goals = new ArrayList<>();
    }

    public void addGoal(Goal goal, int weight) {
        goals.add(new WeightedGoal(weight, goal));
    }

    public void tick() {
        if (goals.isEmpty()) return;

        if (activeGoal != null && !activeGoal.canContinue()) {
            activeGoal.stop();
            activeGoal = null;
        }

        Goal bestGoal = null;
        int bestWeight = 0;

        for (WeightedGoal weightedGoal : goals) {
            Goal goal = weightedGoal.goal();
            int weight = weightedGoal.weight();
            if (goal.canStart() && weight > bestWeight) {
                bestGoal = goal;
                bestWeight = weight;
            }
        }

        if (bestGoal != null && bestGoal != activeGoal) {
            if (activeGoal != null) activeGoal.stop();
            activeGoal = bestGoal;
            bestGoal.start();
        }

        if (activeGoal != null) {
            activeGoal.tick();
        }
    }
}
