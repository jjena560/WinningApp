package com.project.app.winningapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.app.winningapp.model.DietPlan;

public interface DietPlanRepository extends JpaRepository<DietPlan, Long> {
    // You can add custom query methods here if needed
}
