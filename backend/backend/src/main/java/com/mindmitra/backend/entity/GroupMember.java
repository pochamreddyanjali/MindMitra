package com.mindmitra.backend.entity;

import jakarta.persistence.*;

@Entity
public class GroupMember {

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
    // USER EMAIL
    // =========================

    private String userEmail;

    // =========================
    // USER NAME
    // =========================

    private String userName;

    // =========================
    // NGO EMAIL
    // =========================

    private String ngoEmail;

    // =========================
    // JOIN DATE
    // =========================

    private String joinedAt;

    // =========================
    // STATUS
    // =========================

    private String status;

    // =========================
    // CONSTRUCTOR
    // =========================

    public GroupMember() {

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

    public String getUserEmail() {

        return userEmail;

    }

    public void setUserEmail(
            String userEmail) {

        this.userEmail =
                userEmail;

    }

    public String getUserName() {

        return userName;

    }

    public void setUserName(
            String userName) {

        this.userName =
                userName;

    }

    public String getNgoEmail() {

        return ngoEmail;

    }

    public void setNgoEmail(
            String ngoEmail) {

        this.ngoEmail =
                ngoEmail;

    }

    public String getJoinedAt() {

        return joinedAt;

    }

    public void setJoinedAt(
            String joinedAt) {

        this.joinedAt =
                joinedAt;

    }

    public String getStatus() {

        return status;

    }

    public void setStatus(
            String status) {

        this.status =
                status;

    }

}