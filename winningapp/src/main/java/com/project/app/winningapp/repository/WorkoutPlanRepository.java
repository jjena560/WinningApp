package com.project.app.winningapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.app.winningapp.model.WorkoutPlan;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {
    // You can add custom query methods here if needed
}
