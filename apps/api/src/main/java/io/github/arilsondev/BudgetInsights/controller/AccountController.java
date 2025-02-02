package io.github.arilsondev.BudgetInsights.controller;

import io.github.arilsondev.BudgetInsights.model.Account;
import io.github.arilsondev.BudgetInsights.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
  @Autowired
  private AccountService accountService;

  @GetMapping
  public List<Account> findAll() {
    return accountService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Account> findById(@PathVariable Long id) {
    return accountService.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/user/{userId}")
  public List<Account> findByUserId(@PathVariable Long userId) {
    return accountService.findByUserId(userId);
  }

  @PostMapping
  public ResponseEntity<Account> create(@RequestBody Account account) {
    return ResponseEntity.ok(accountService.save(account));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Account> update(@PathVariable Long id, @RequestBody Account account) {
    return accountService.findById(id)
        .map(existingAccount -> {
          account.setId(id);
          return ResponseEntity.ok(accountService.save(account));
        })
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    accountService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}