package io.github.arilsondev.BudgetInsights.service;

import io.github.arilsondev.BudgetInsights.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
  User save(User user);

  List<User> findAll();
  
  Optional<User> findByEmail(String email);

  Optional<User> findById(Long id);

  User update(User user);

  void delete(Long id);
}
