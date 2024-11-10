package io.github.arilsondev.BudgetInsights.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "preferences", uniqueConstraints = {
  @UniqueConstraint(columnNames = { "key" })
})
public class Preference {
  
  @Id
  private String key;

  private String value;
}
