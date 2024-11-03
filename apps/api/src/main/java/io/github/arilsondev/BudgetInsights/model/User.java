package io.github.arilsondev.BudgetInsights.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  public long id;

  public String name;

  public String email;

  public String password;
}