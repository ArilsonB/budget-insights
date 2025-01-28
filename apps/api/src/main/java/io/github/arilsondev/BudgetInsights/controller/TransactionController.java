package io.github.arilsondev.BudgetInsights.controller;

import io.github.arilsondev.BudgetInsights.model.Transaction;
import io.github.arilsondev.BudgetInsights.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> findAll() {
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable Long id) {
        return transactionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/account/{accountId}")
    public List<Transaction> findByAccountId(@PathVariable Long accountId) {
        return transactionService.findByAccountId(accountId);
    }

    @GetMapping("/date-range")
    public List<Transaction> findByDateRange(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end) {
        return transactionService.findByDateRange(start, end);
    }

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.save(transaction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> update(@PathVariable Long id, @RequestBody Transaction transaction) {
        return transactionService.findById(id)
                .map(existingTransaction -> {
                    transaction.setId(id);
                    return ResponseEntity.ok(transactionService.save(transaction));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}