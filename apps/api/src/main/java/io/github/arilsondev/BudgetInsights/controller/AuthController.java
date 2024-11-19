package io.github.arilsondev.BudgetInsights.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.github.arilsondev.BudgetInsights.service.AuthService;
import jakarta.validation.Valid;

import io.github.arilsondev.BudgetInsights.dto.AuthRequestDTO;
import io.github.arilsondev.BudgetInsights.model.User;


@RestController
@RequestMapping("/api/v1")
public class AuthController {

  @Autowired
  private AuthService authService;

  @PostMapping("/signin")
  public ResponseEntity<User> signin(@Valid @RequestBody AuthRequestDTO authRequest) {
    User entity = authService.signIn(authRequest.getEmail(), authRequest.getPassword());

    return ResponseEntity.ok().body(entity);
  }
  
}
