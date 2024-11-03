package io.github.arilsondev.BudgetInsights.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.arilsondev.BudgetInsights.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  public Optional<User> findByEmail(String email);
}
