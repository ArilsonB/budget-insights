/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.arilsondev.BudgetInsights.util;

import org.springframework.stereotype.Component;

/**
 *
 * @author arilson
 */

@Component
public class JwtUtil {
  private final String SECRET_KEY = "secret";

  public String generateToken(String email) {
    return null;
  }

  public boolean validateToken(String token) {
    return false;
  }

  private boolean isTokenExpired(String token) {
    return false;
  }

  public String extractEmail(String token) {
    return null;
  }



}
