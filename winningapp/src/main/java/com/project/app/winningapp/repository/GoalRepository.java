package com.project.app.winningapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.app.winningapp.model.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    // You can add custom query methods here if needed
}
