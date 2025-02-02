package io.github.arilsondev.BudgetInsights.dto;

import io.github.arilsondev.BudgetInsights.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
    private User user;
    private String token;
}