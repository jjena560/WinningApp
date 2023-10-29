package com.project.app.winningapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.app.winningapp.model.Goal;
import com.project.app.winningapp.model.User;
import com.project.app.winningapp.repository.GoalRepository;
import com.project.app.winningapp.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    private GoalRepository goalRepository;


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(String username, String email, String password, int age) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setAge(age);

        return userRepository.save(user);
    }

    // Implement additional methods as needed for user authentication and profile management
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUserProfile(Long id, String username, String email, int age) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setUsername(username);
            user.setEmail(email);
            user.setAge(age);
            return userRepository.save(user);
        }
        return null;
    }
    
    public Goal createGoal(String title, String description) {
        Goal goal = new Goal();
        goal.setTitle(title);
        goal.setDescription(description);
        return goalRepository.save(goal);
    }
}
