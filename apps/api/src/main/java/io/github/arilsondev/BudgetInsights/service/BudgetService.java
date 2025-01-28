package io.github.arilsondev.BudgetInsights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import io.github.arilsondev.BudgetInsights.model.Budget;
import io.github.arilsondev.BudgetInsights.repository.BudgetRepository;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepository budgetRepository;

    public Budget save(Budget budget) {
        return budgetRepository.save(budget);
    }

    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }

    public Optional<Budget> findById(Long id) {
        return budgetRepository.findById(id);
    }

    public List<Budget> findByUserId(Long userId) {
        return budgetRepository.findByUserId(userId);
    }

    public List<Budget> findByUserIdAndCategoryId(Long userId, Long categoryId) {
        return budgetRepository.findByUserIdAndCategoryId(userId, categoryId);
    }

    public void deleteById(Long id) {
        budgetRepository.deleteById(id);
    }
}