package com.mindmitra.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // USER DETAILS
    // =========================

    private String userName;

    private String userEmail;

    @Column(length = 3000)
    private String issue;

    private String preferredTiming;

    // =========================
    // SPECIALIST DETAILS
    // =========================

    private String specialistEmail;

    private String specialistName;

    // =========================
    // APPOINTMENT STATUS
    // =========================

    private String status = "PENDING";
    // PENDING
    // ACCEPTED
    // REJECTED

    // =========================
    // SPECIALIST RESPONSE
    // =========================

    @Column(length = 3000)
    private String specialistOpinion;

    private String specialistAvailability;

    private String communicationMode;

    @Column(length = 3000)
    private String meetingLink;

    // =========================
    // CONSTRUCTORS
    // =========================

    public Appointment() {

    }

    // =========================
    // GETTERS AND SETTERS
    // =========================

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public String getUserName() {

        return userName;

    }

    public void setUserName(String userName) {

        this.userName = userName;

    }

    public String getUserEmail() {

        return userEmail;

    }

    public void setUserEmail(String userEmail) {

        this.userEmail = userEmail;

    }

    public String getIssue() {

        return issue;

    }

    public void setIssue(String issue) {

        this.issue = issue;

    }

    public String getPreferredTiming() {

        return preferredTiming;

    }

    public void setPreferredTiming(String preferredTiming) {

        this.preferredTiming = preferredTiming;

    }

    public String getSpecialistEmail() {

        return specialistEmail;

    }

    public void setSpecialistEmail(String specialistEmail) {

        this.specialistEmail = specialistEmail;

    }

    public String getSpecialistName() {

        return specialistName;

    }

    public void setSpecialistName(String specialistName) {

        this.specialistName = specialistName;

    }

    public String getStatus() {

        return status;

    }

    public void setStatus(String status) {

        this.status = status;

    }

    public String getSpecialistOpinion() {

        return specialistOpinion;

    }

    public void setSpecialistOpinion(String specialistOpinion) {

        this.specialistOpinion = specialistOpinion;

    }

    public String getSpecialistAvailability() {

        return specialistAvailability;

    }

    public void setSpecialistAvailability(String specialistAvailability) {

        this.specialistAvailability = specialistAvailability;

    }

    public String getCommunicationMode() {

        return communicationMode;

    }

    public void setCommunicationMode(String communicationMode) {

        this.communicationMode = communicationMode;

    }

    public String getMeetingLink() {

        return meetingLink;

    }

    public void setMeetingLink(String meetingLink) {

        this.meetingLink = meetingLink;

    }
}