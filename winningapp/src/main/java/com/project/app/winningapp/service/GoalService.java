package com.project.app.winningapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.app.winningapp.model.Goal;
import com.project.app.winningapp.repository.GoalRepository;

@Service
public class GoalService {
    private final GoalRepository goalRepository;

    @Autowired
    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public Goal createGoal(String title, String description) {
        Goal goal = new Goal();
        goal.setTitle(title);
        goal.setDescription(description);

        return goalRepository.save(goal);
    }

    public Goal getGoalById(Long id) {
        return goalRepository.findById(id).orElse(null);
    }

    // Add other methods as needed for goal management
}
