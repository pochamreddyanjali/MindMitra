package com.mindmitra.backend.entity;

import jakarta.persistence.*;

@Entity
public class NgoAnnouncement {

    // =========================
    // ID
    // =========================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // GROUP ID
    // =========================

    private Long groupId;

    // =========================
    // GROUP NAME
    // =========================

    private String groupName;

    // =========================
    // NGO EMAIL
    // =========================

    private String ngoEmail;

    // =========================
    // NGO NAME
    // =========================

    private String ngoName;

    // =========================
    // ANNOUNCEMENT TITLE
    // =========================

    private String title;

    // =========================
    // ANNOUNCEMENT MESSAGE
    // =========================

    @Column(columnDefinition = "TEXT")
    private String message;

    @Column(columnDefinition = "TEXT")
    private String meetingLink;

    @Column(columnDefinition = "TEXT")
    private String eventDetails;

    // =========================
    // CREATED DATE
    // =========================

    private String createdAt;

    // =========================
    // CONSTRUCTOR
    // =========================

    public NgoAnnouncement() {

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

    public Long getGroupId() {

        return groupId;

    }

    public void setGroupId(
            Long groupId) {

        this.groupId =
                groupId;

    }

    public String getGroupName() {

        return groupName;

    }

    public void setGroupName(
            String groupName) {

        this.groupName =
                groupName;

    }

    public String getNgoEmail() {

        return ngoEmail;

    }

    public void setNgoEmail(
            String ngoEmail) {

        this.ngoEmail =
                ngoEmail;

    }

    public String getNgoName() {

        return ngoName;

    }

    public void setNgoName(
            String ngoName) {

        this.ngoName =
                ngoName;

    }

    public String getTitle() {

        return title;

    }

    public void setTitle(
            String title) {

        this.title =
                title;

    }

    public String getMessage() {

        return message;

    }

    public void setMessage(
            String message) {

        this.message =
                message;

    }

    public String getMeetingLink() {

        return meetingLink;

    }

    public void setMeetingLink(
            String meetingLink) {

        this.meetingLink =
                meetingLink;

    }

    public String getEventDetails() {

        return eventDetails;

    }

    public void setEventDetails(
            String eventDetails) {

        this.eventDetails =
                eventDetails;

    }

    public String getCreatedAt() {

        return createdAt;

    }

    public void setCreatedAt(
            String createdAt) {

        this.createdAt =
                createdAt;

    }

}
