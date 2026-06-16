package com.mindmitra.backend.entity;

import jakarta.persistence.*;

@Entity
public class NgoGroup {

    // =========================
    // ID
    // =========================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // GROUP NAME
    // =========================

    private String groupName;

    // =========================
    // DESCRIPTION
    // =========================

    @Column(length = 5000)
    private String description;

    // =========================
    // GROUP PRIVACY
    // PUBLIC / PRIVATE
    // =========================

    private String privacy;

    // =========================
    // NGO EMAIL
    // GROUP OWNER
    // =========================

    private String ngoEmail;

    // =========================
    // NGO NAME
    // =========================

    private String ngoName;

    // =========================
    // MEETING LINK
    // =========================

    @Column(length = 3000)
    private String meetingLink;

    // =========================
    // OUTDOOR ACTIVITY DETAILS
    // =========================

    @Column(length = 5000)
    private String activityDetails;

    // =========================
    // CREATED DATE
    // =========================

    private String createdAt;

    // =========================
    // CONSTRUCTOR
    // =========================

    public NgoGroup() {

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

    public String getGroupName() {

        return groupName;

    }

    public void setGroupName(
            String groupName) {

        this.groupName =
                groupName;

    }

    public String getDescription() {

        return description;

    }

    public void setDescription(
            String description) {

        this.description =
                description;

    }

    public String getPrivacy() {

        return privacy;

    }

    public void setPrivacy(
            String privacy) {

        this.privacy =
                privacy;

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

    public String getMeetingLink() {

        return meetingLink;

    }

    public void setMeetingLink(
            String meetingLink) {

        this.meetingLink =
                meetingLink;

    }

    public String getActivityDetails() {

        return activityDetails;

    }

    public void setActivityDetails(
            String activityDetails) {

        this.activityDetails =
                activityDetails;

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