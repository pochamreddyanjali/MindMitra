package com.mindmitra.backend.entity;

import jakarta.persistence.*;

@Entity
public class PollVote {

    // =========================
    // ID
    // =========================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // POLL ID
    // =========================

    private Long pollId;

    // =========================
    // GROUP ID
    // =========================

    private Long groupId;

    // =========================
    // USER EMAIL
    // =========================

    private String userEmail;

    // =========================
    // USER NAME
    // =========================

    private String userName;

    // =========================
    // SELECTED OPTION
    // =========================

    private String selectedOption;

    // =========================
    // VOTED DATE
    // =========================

    private String votedAt;

    // =========================
    // CONSTRUCTOR
    // =========================

    public PollVote() {

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

    public Long getPollId() {

        return pollId;

    }

    public void setPollId(
            Long pollId) {

        this.pollId =
                pollId;

    }

    public Long getGroupId() {

        return groupId;

    }

    public void setGroupId(
            Long groupId) {

        this.groupId =
                groupId;

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

    public String getSelectedOption() {

        return selectedOption;

    }

    public void setSelectedOption(
            String selectedOption) {

        this.selectedOption =
                selectedOption;

    }

    public String getVotedAt() {

        return votedAt;

    }

    public void setVotedAt(
            String votedAt) {

        this.votedAt =
                votedAt;

    }

}
