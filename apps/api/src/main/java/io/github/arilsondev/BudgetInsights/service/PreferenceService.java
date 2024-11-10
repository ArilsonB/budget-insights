package io.github.arilsondev.BudgetInsights.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.arilsondev.BudgetInsights.model.Preference;
import io.github.arilsondev.BudgetInsights.repository.PreferenceRepository;

@Service
public class PreferenceService {
  @Autowired
  private PreferenceRepository preferenceRepository;

  public Preference save(Preference preference) {
    return preferenceRepository.save(preference);
  }

  public List<Preference> findAll() {
    return preferenceRepository.findAll();
  }

  public Optional<Preference> findById(String id) {
    return preferenceRepository.findById(id);
  }


}
