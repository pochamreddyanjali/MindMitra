package com.mindmitra.backend.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "meditation_tracker")

public class MeditationTracker {

    // =========================
    // ID
    // =========================

    @Id

    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )

    private Long id;

    // =========================
    // USER EMAIL
    // =========================

    private String userEmail;

    // =========================
    // DATE
    // =========================

    private LocalDate date;

    // =========================
    // MINUTES
    // =========================

    private int minutes;

    // =========================
    // COMPLETED
    // =========================

    private boolean completed;

    // =========================
    // DEFAULT CONSTRUCTOR
    // =========================

    public MeditationTracker() {

    }

    // =========================
    // GETTERS & SETTERS
    // =========================

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public String getUserEmail() {

        return userEmail;

    }

    public void setUserEmail(
            String userEmail) {

        this.userEmail = userEmail;

    }

    public LocalDate getDate() {

        return date;

    }

    public void setDate(
            LocalDate date) {

        this.date = date;

    }

    public int getMinutes() {

        return minutes;

    }

    public void setMinutes(
            int minutes) {

        this.minutes = minutes;

    }

    public boolean isCompleted() {

        return completed;

    }

    public void setCompleted(
            boolean completed) {

        this.completed = completed;

    }

}

