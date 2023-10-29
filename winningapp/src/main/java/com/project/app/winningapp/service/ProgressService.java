package com.project.app.winningapp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.app.winningapp.model.Progress;
import com.project.app.winningapp.model.User;
import com.project.app.winningapp.repository.ProgressRepository;

@Service
public class ProgressService {
    private final ProgressRepository progressRepository;

    @Autowired
    public ProgressService(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    public Progress logProgress(User user, double weight, double bodyFat, double muscleMass) {
        Progress progress = new Progress();
        progress.setUser(user);
        progress.setWeight(weight);
        progress.setBodyFat(bodyFat);
        progress.setMuscleMass(muscleMass);
        progress.setDate(new Date());

        return progressRepository.save(progress);
    }

    // Add other methods as needed for progress tracking
}
