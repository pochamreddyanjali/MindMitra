package com.mindmitra.backend.entity;

import jakarta.persistence.*;

@Entity
public class NgoPoll {

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
    // POLL QUESTION
    // =========================

    @Column(length = 3000)
    private String question;

    // =========================
    // OPTION 1
    // =========================

    private String option1;

    // =========================
    // OPTION 2
    // =========================

    private String option2;

    // =========================
    // OPTION 3
    // =========================

    private String option3;

    // =========================
    // OPTION 4
    // =========================

    private String option4;

    // =========================
    // CREATED DATE
    // =========================

    private String createdAt;

    // =========================
    // CONSTRUCTOR
    // =========================

    public NgoPoll() {

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

    public String getQuestion() {

        return question;

    }

    public void setQuestion(
            String question) {

        this.question =
                question;

    }

    public String getOption1() {

        return option1;

    }

    public void setOption1(
            String option1) {

        this.option1 =
                option1;

    }

    public String getOption2() {

        return option2;

    }

    public void setOption2(
            String option2) {

        this.option2 =
                option2;

    }

    public String getOption3() {

        return option3;

    }

    public void setOption3(
            String option3) {

        this.option3 =
                option3;

    }

    public String getOption4() {

        return option4;

    }

    public void setOption4(
            String option4) {

        this.option4 =
                option4;

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