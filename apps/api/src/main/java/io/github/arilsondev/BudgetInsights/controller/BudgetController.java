package io.github.arilsondev.BudgetInsights.controller;

import io.github.arilsondev.BudgetInsights.model.Budget;
import io.github.arilsondev.BudgetInsights.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/budgets")
public class BudgetController {
    @Autowired
    private BudgetService budgetService;

    @GetMapping
    public List<Budget> findAll() {
        return budgetService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Budget> findById(@PathVariable Long id) {
        return budgetService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<Budget> findByUserId(@PathVariable Long userId) {
        return budgetService.findByUserId(userId);
    }

    @GetMapping("/user/{userId}/category/{categoryId}")
    public List<Budget> findByUserIdAndCategoryId(
            @PathVariable Long userId,
            @PathVariable Long categoryId) {
        return budgetService.findByUserIdAndCategoryId(userId, categoryId);
    }

    @PostMapping
    public ResponseEntity<Budget> create(@RequestBody Budget budget) {
        return ResponseEntity.ok(budgetService.save(budget));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Budget> update(@PathVariable Long id, @RequestBody Budget budget) {
        return budgetService.findById(id)
                .map(existingBudget -> {
                    budget.setId(id);
                    return ResponseEntity.ok(budgetService.save(budget));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        budgetService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}