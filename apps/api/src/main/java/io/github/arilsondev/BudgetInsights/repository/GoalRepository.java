package io.github.arilsondev.BudgetInsights.repository;

import io.github.arilsondev.BudgetInsights.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByUserId(Long userId);
    List<Goal> findByUserIdAndPriority(Long userId, String priority);
}