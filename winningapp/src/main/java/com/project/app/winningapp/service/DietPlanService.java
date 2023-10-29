package com.project.app.winningapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.app.winningapp.model.DietPlan;
import com.project.app.winningapp.model.Goal;
import com.project.app.winningapp.model.User;
import com.project.app.winningapp.repository.DietPlanRepository;

@Service
public class DietPlanService {
    private final DietPlanRepository dietPlanRepository;

    @Autowired
    public DietPlanService(DietPlanRepository dietPlanRepository) {
        this.dietPlanRepository = dietPlanRepository;
    }

    public DietPlan generateDietPlan(User user, Goal goal) {
        // Add your logic here to generate diet plans based on user and goal information
        // You can customize diet plans based on user preferences, fitness level, and goal type

        DietPlan dietPlan = new DietPlan();
        dietPlan.setTitle("Custom Diet Plan");
        dietPlan.setDescription("This is a sample diet plan.");
        dietPlan.setDuration("4 weeks");
        // Set other diet plan attributes as needed

        return dietPlanRepository.save(dietPlan);
    }
}
