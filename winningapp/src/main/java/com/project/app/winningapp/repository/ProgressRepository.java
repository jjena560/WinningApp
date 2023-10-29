package com.project.app.winningapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.app.winningapp.model.Progress;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
    // You can add custom query methods here if needed
}
