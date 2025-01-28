package io.github.arilsondev.BudgetInsights.controller;

import io.github.arilsondev.BudgetInsights.model.Reminder;
import io.github.arilsondev.BudgetInsights.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {
    @Autowired
    private ReminderService reminderService;

    @GetMapping
    public List<Reminder> findAll() {
        return reminderService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reminder> findById(@PathVariable Long id) {
        return reminderService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<Reminder> findByUserId(@PathVariable Long userId) {
        return reminderService.findByUserId(userId);
    }

    @GetMapping("/date-range")
    public List<Reminder> findByDateRange(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end) {
        return reminderService.findByDateRange(start, end);
    }
    @PostMapping
    public Reminder save(@RequestBody Reminder reminder) {
        return reminderService.save(reminder);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reminderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
