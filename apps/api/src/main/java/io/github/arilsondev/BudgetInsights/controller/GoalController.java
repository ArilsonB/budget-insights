package io.github.arilsondev.BudgetInsights.controller;

import io.github.arilsondev.BudgetInsights.model.Goal;
import io.github.arilsondev.BudgetInsights.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/goals")
public class GoalController {
    @Autowired
    private GoalService goalService;

    @GetMapping
    public List<Goal> findAll() {
        return goalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goal> findById(@PathVariable Long id) {
        return goalService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<Goal> findByUserId(@PathVariable Long userId) {
        return goalService.findByUserId(userId);
    }

    @GetMapping("/user/{userId}/priority/{priority}")
    public List<Goal> findByUserIdAndPriority(
            @PathVariable Long userId,
            @PathVariable String priority) {
        return goalService.findByUserIdAndPriority(userId, priority);
    }

    @PostMapping
    public ResponseEntity<Goal> create(@RequestBody Goal goal) {
        return ResponseEntity.ok(goalService.save(goal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Goal> update(@PathVariable Long id, @RequestBody Goal goal) {
        return goalService.findById(id)
                .map(existingGoal -> {
                    goal.setId(id);
                    return ResponseEntity.ok(goalService.save(goal));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        goalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}