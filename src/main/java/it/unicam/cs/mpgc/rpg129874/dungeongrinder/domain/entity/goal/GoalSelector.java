package it.unicam.cs.mpgc.rpg129874.dungeongrinder.domain.entity.goal;

import java.util.ArrayList;

public class GoalSelector {
    private final ArrayList<WeightedGoal> goals;

    public GoalSelector() {
        this.goals = new ArrayList<>();
    }

    public void addGoal(Goal goal, int weight) {
        goals.add(new WeightedGoal(weight, goal));
    }

    public void tick() {
        Goal selectedGoal = null;
        int weight = 0;
        for (WeightedGoal weightedGoal : goals) {
            Goal goal = weightedGoal.goal();
            if (goal.canStart() && weightedGoal.weight() > weight) {
                selectedGoal = goal;
                weight = weightedGoal.weight();
            }
        }

        if (selectedGoal == null) return;
        selectedGoal.tick();
    }
}
