package io.github.arilsondev.BudgetInsights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.arilsondev.BudgetInsights.model.User;
import io.github.arilsondev.BudgetInsights.repository.UserRepository;

@Service
public class AuthService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public User signIn(String email, String password) {
    User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

    if (!passwordEncoder.matches(password, user.getPassword())) {
      throw new RuntimeException("Invalid password");
    }
    
    return user;
  }
  
  public void signUp() {

  }
  
  public void forgetPassword() {
  }

  public void resetPassword() {
  }
}
