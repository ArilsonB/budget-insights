package io.github.arilsondev.BudgetInsights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.arilsondev.BudgetInsights.model.User;
import io.github.arilsondev.BudgetInsights.repository.UserRepository;
import io.github.arilsondev.BudgetInsights.util.JwtUtil;
import io.github.arilsondev.BudgetInsights.dto.AuthResponseDTO;

@Service
public class AuthService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtUtil jwtUtil;

  public AuthResponseDTO signIn(String email, String password) {
    User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

    if (!passwordEncoder.matches(password, user.getPassword())) {
      throw new RuntimeException("Invalid password");
    }

    String token = jwtUtil.generateToken(user.getEmail());
    return new AuthResponseDTO(user, token);
  }
  
  public void signUp() {

  }
  
  public void forgetPassword() {
  }

  public void resetPassword() {
  }
}
