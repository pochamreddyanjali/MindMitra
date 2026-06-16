package com.mindmitra.backend.entity;

import jakarta.persistence.*;

@Entity
public class NgoFollower {

    // =========================
    // ID
    // =========================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // USER EMAIL
    // =========================

    private String userEmail;

    // =========================
    // NGO EMAIL
    // =========================

    private String ngoEmail;

    // =========================
    // CONSTRUCTOR
    // =========================

    public NgoFollower() {

    }

    // =========================
    // GET ID
    // =========================

    public Long getId() {

        return id;

    }

    // =========================
    // SET ID
    // =========================

    public void setId(Long id) {

        this.id = id;

    }

    // =========================
    // GET USER EMAIL
    // =========================

    public String getUserEmail() {

        return userEmail;

    }

    // =========================
    // SET USER EMAIL
    // =========================

    public void setUserEmail(String userEmail) {

        this.userEmail = userEmail;

    }

    // =========================
    // GET NGO EMAIL
    // =========================

    public String getNgoEmail() {

        return ngoEmail;

    }

    // =========================
    // SET NGO EMAIL
    // =========================

    public void setNgoEmail(String ngoEmail) {

        this.ngoEmail = ngoEmail;

    }

}