package io.github.arilsondev.BudgetInsights.repository;

import io.github.arilsondev.BudgetInsights.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountId(Long accountId);
    List<Transaction> findByTransactionAtBetween(LocalDateTime start, LocalDateTime end);
    List<Transaction> findByAccountIdAndTransactionAtBetween(Long accountId, LocalDateTime start, LocalDateTime end);
}