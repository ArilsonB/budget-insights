package io.github.arilsondev.BudgetInsights.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;

  @NotBlank
  private String name;

  @NotBlank
  private String lastname;

  @Email
  @NotBlank
  private String email;

  @NotBlank
  private String password;
}