package com.mindmitra.backend.entity;

import jakarta.persistence.*;

@Entity
public class Message {

    // =========================
    // ID
    // =========================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // SENDER EMAIL
    // =========================

    private String senderEmail;

    // =========================
    // RECEIVER EMAIL
    // =========================

    private String receiverEmail;

    // =========================
    // MESSAGE
    // =========================

    @Column(length = 5000)
    private String message;

    // =========================
    // TIMESTAMP
    // =========================

    private String timestamp;

    // =========================
    // SEEN STATUS
    // =========================

    private boolean seen = false;

    // =========================
    // CONSTRUCTOR
    // =========================

    public Message() {

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

    public String getSenderEmail() {

        return senderEmail;

    }

    public void setSenderEmail(
            String senderEmail) {

        this.senderEmail =
                senderEmail;

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

    public String getTimestamp() {

        return timestamp;

    }

    public void setTimestamp(
            String timestamp) {

        this.timestamp =
                timestamp;

    }

    // =========================
    // SEEN
    // =========================

    public boolean isSeen() {

        return seen;

    }

    public void setSeen(boolean seen) {

        this.seen = seen;

    }

}