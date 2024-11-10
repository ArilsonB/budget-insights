package io.github.arilsondev.BudgetInsights.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.arilsondev.BudgetInsights.model.User;
import io.github.arilsondev.BudgetInsights.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public User save(User user) {
    return userRepository.save(user);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public Optional<User> findById(Long id) {
    return userRepository.findById(id);
  }


  @Transactional
  public User update(Long id, User user) {
     return userRepository.findById(id)
            .map(item -> {
                item.setName(user.getName());
                return userRepository.save(item);
            })
            .orElseThrow(() -> new RuntimeException("Item not found"));
  }

  public void delete(Long id) {
    userRepository.deleteById(id);
  }
  
}
