package io.github.arilsondev.BudgetInsights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import io.github.arilsondev.BudgetInsights.model.Transaction;
import io.github.arilsondev.BudgetInsights.repository.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    public List<Transaction> findByAccountId(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    public List<Transaction> findByDateRange(LocalDateTime start, LocalDateTime end) {
        return transactionRepository.findByTransactionAtBetween(start, end);
    }

    public List<Transaction> findByAccountAndDateRange(Long accountId, LocalDateTime start, LocalDateTime end) {
        return transactionRepository.findByAccountIdAndTransactionAtBetween(accountId, start, end);
    }

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }
}