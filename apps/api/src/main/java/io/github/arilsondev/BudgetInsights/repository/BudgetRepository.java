package io.github.arilsondev.BudgetInsights.repository;

import io.github.arilsondev.BudgetInsights.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
    List<Budget> findByUserId(Long userId);
    List<Budget> findByUserIdAndCategoryId(Long userId, Long categoryId);
}