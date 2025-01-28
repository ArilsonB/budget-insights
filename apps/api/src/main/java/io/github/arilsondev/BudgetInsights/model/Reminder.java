package io.github.arilsondev.BudgetInsights.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reminders")
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reminder_id")
    private Long reminderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String description;

    @Column(name = "reminder_date", nullable = false)
    private LocalDateTime reminderDate;

    @Column(nullable = false)
    private String repeat;

    // Getters and Setters
}