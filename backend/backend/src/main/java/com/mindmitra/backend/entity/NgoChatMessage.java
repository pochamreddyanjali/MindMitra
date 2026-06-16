package com.mindmitra.backend.entity;

import jakarta.persistence.*;

@Entity
public class NgoChatMessage {

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
    // SENDER EMAIL
    // =========================

    private String senderEmail;

    // =========================
    // SENDER NAME
    // =========================

    private String senderName;

    // =========================
    // RECEIVER EMAIL
    // =========================

    private String receiverEmail;

    // =========================
    // MESSAGE
    // =========================

    @Column(length = 10000)
    private String message;

    // =========================
    // SEEN STATUS
    // =========================

    private boolean seen = false;

    // =========================
    // TIMESTAMP
    // =========================

    private String timestamp;

    // =========================
    // CONSTRUCTOR
    // =========================

    public NgoChatMessage() {

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

    public String getSenderEmail() {

        return senderEmail;

    }

    public void setSenderEmail(
            String senderEmail) {

        this.senderEmail =
                senderEmail;

    }

    public String getSenderName() {

        return senderName;

    }

    public void setSenderName(
            String senderName) {

        this.senderName =
                senderName;

    }

    public String getReceiverEmail() {

        return receiverEmail;

    }

    public void setReceiverEmail(
            String receiverEmail) {

        this.receiverEmail =
                receiverEmail;

    }

    public String getMessage() {

        return message;

    }

    public void setMessage(
            String message) {

        this.message =
                message;

    }

    public boolean isSeen() {

        return seen;

    }

    public void setSeen(
            boolean seen) {

        this.seen =
                seen;

    }

    public String getTimestamp() {

        return timestamp;

    }

    public void setTimestamp(
            String timestamp) {

        this.timestamp =
                timestamp;

    }

}