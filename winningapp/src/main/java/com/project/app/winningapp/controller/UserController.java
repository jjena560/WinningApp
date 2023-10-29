package com.project.app.winningapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.project.app.winningapp.model.DietPlan;
import com.project.app.winningapp.model.Goal;
import com.project.app.winningapp.model.Progress;
import com.project.app.winningapp.model.PushNotificationRequest;
import com.project.app.winningapp.model.User;
import com.project.app.winningapp.model.WorkoutPlan;
import com.project.app.winningapp.service.DietPlanService;
import com.project.app.winningapp.service.GoalService;
import com.project.app.winningapp.service.ProgressService;
import com.project.app.winningapp.service.PushNotificationService;
import com.project.app.winningapp.service.UserService;
import com.project.app.winningapp.service.WorkoutPlanService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    
    @Autowired
    private GoalService goalService;
    
    @Autowired
    private WorkoutPlanService workoutPlanService;
    
    @Autowired
    private DietPlanService dietPlanService;
    
    @Autowired
    private ProgressService progressService;
    
    @Autowired
    private PushNotificationService pushNotificationService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        // Perform validation if needed before creating the user
        return userService.createUser(user.getUsername(), user.getEmail(), user.getPassword(), user.getAge());
    }

    // Add other endpoints for user profile management and authentication
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUserProfile(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUserProfile(id, user.getUsername(), user.getEmail(), user.getAge());
    }
    
    @PostMapping("/{userId}/goals")
    public Goal createGoal(@PathVariable Long userId, @RequestBody Goal goal) {
        // Validate userId and goal data if needed
        return userService.createGoal(goal.getTitle(), goal.getDescription());
    }
    
    @PostMapping("/{userId}/goals/{goalId}/workout-plan")
    public WorkoutPlan generateWorkoutPlan(@PathVariable Long userId, @PathVariable Long goalId) {
        // Fetch user and goal from the database based on userId and goalId
        User user = userService.getUserById(userId);
        Goal goal = goalService.getGoalById(goalId);

        // Perform validation if needed

        return workoutPlanService.generateWorkoutPlan(user, goal);
    }
    
    @PostMapping("/{userId}/goals/{goalId}/diet-plan")
    public DietPlan generateDietPlan(@PathVariable Long userId, @PathVariable Long goalId) {
        // Fetch user and goal from the database based on userId and goalId
        User user = userService.getUserById(userId);
        Goal goal = goalService.getGoalById(goalId);

        // Perform validation if needed

        return dietPlanService.generateDietPlan(user, goal);
    }
    
    @PostMapping("/{userId}/progress")
    public Progress logProgress(@PathVariable Long userId, @RequestBody Progress progress) {
        // Fetch user from the database based on userId
        User user = userService.getUserById(userId);

        // Perform validation if needed

        return progressService.logProgress(user, progress.getWeight(), progress.getBodyFat(), progress.getMuscleMass());
    }
    
    @PostMapping("/{userId}/send-notification")
    public void sendNotification(@PathVariable Long userId, @RequestBody PushNotificationRequest request) {
        // Fetch user from the database based on userId
        User user = userService.getUserById(userId);

        // Perform validation if needed

        // Get the user's device token (Assuming you have stored it in the User entity)
        String deviceToken = user.getDeviceToken();

        // Send push notification
        try {
            pushNotificationService.sendPushNotification(request.getTitle(), request.getBody(), deviceToken);
        } catch (FirebaseMessagingException e) {
            // Handle the exception appropriately
            e.printStackTrace();
        }
    }

}
