package com.mindmitra.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 5000)
    private String content;

    private String mood;

    private String gratitude;

    // NEW DATE FIELD

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructor

    public Journal() {

    }

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getGratitude() {
        return gratitude;
    }

    public void setGratitude(String gratitude) {
        this.gratitude = gratitude;
    }

    // DATE GETTER/SETTER

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}