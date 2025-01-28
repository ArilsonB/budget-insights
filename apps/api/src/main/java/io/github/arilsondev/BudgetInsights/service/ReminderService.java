package io.github.arilsondev.BudgetInsights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import io.github.arilsondev.BudgetInsights.model.Reminder;
import io.github.arilsondev.BudgetInsights.repository.ReminderRepository;

@Service
public class ReminderService {
    @Autowired
    private ReminderRepository reminderRepository;

    public Reminder save(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    public List<Reminder> findAll() {
        return reminderRepository.findAll();
    }

    public Optional<Reminder> findById(Long id) {
        return reminderRepository.findById(id);
    }

    public List<Reminder> findByUserId(Long userId) {
        return reminderRepository.findByUserId(userId);
    }

    public List<Reminder> findByDateRange(LocalDateTime start, LocalDateTime end) {
        return reminderRepository.findByReminderDateBetween(start, end);
    }

    public void deleteById(Long id) {
        reminderRepository.deleteById(id);
    }
}