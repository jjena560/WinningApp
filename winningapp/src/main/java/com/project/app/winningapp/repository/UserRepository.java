package com.project.app.winningapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.app.winningapp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom query methods here if needed
}
