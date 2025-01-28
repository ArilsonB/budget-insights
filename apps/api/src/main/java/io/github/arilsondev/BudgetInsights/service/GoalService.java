package io.github.arilsondev.BudgetInsights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import io.github.arilsondev.BudgetInsights.model.Goal;
import io.github.arilsondev.BudgetInsights.repository.GoalRepository;

@Service
public class GoalService {
    @Autowired
    private GoalRepository goalRepository;

    public Goal save(Goal goal) {
        return goalRepository.save(goal);
    }

    public List<Goal> findAll() {
        return goalRepository.findAll();
    }

    public Optional<Goal> findById(Long id) {
        return goalRepository.findById(id);
    }

    public List<Goal> findByUserId(Long userId) {
        return goalRepository.findByUserId(userId);
    }

    public List<Goal> findByUserIdAndPriority(Long userId, String priority) {
        return goalRepository.findByUserIdAndPriority(userId, priority);
    }

    public void deleteById(Long id) {
        goalRepository.deleteById(id);
    }
}