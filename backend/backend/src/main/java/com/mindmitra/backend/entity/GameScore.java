package com.mindmitra.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class GameScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gameName;

    private int score;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // CONSTRUCTOR

    public GameScore() {

    }

    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

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
