package io.github.arilsondev.BudgetInsights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.arilsondev.BudgetInsights.model.Preference;
/**
 *
 * @author arilson
 */
public interface PreferenceRepository extends JpaRepository<Preference, String> {}
