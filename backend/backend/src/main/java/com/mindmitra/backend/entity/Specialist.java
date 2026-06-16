package com.mindmitra.backend.entity;

import jakarta.persistence.*;

@Entity
public class Specialist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String phone;

    private String specialization;

    private String qualification;

    private String experience;

    @Column(length = 3000)
    private String bio;

    // PROFILE IMAGE

    @Column(length = 100000)
    private String profileImage;

    // APPROVAL STATUS

    private String status = "PENDING";

    // REJECTION REASON

    @Column(length = 3000)
    private String rejectionReason;

    // CONSTRUCTOR

    public Specialist() {

    }

    // GETTERS AND SETTERS

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public String getEmail() {

        return email;

    }

    public void setEmail(String email) {

        this.email = email;

    }

    public String getPassword() {

        return password;

    }

    public void setPassword(String password) {

        this.password = password;

    }

    public String getPhone() {

        return phone;

    }

    public void setPhone(String phone) {

        this.phone = phone;

    }

    public String getSpecialization() {

        return specialization;

    }

    public void setSpecialization(String specialization) {

        this.specialization = specialization;

    }

    public String getQualification() {

        return qualification;

    }

    public void setQualification(String qualification) {

        this.qualification = qualification;

    }

    public String getExperience() {

        return experience;

    }

    public void setExperience(String experience) {

        this.experience = experience;

    }

    public String getBio() {

        return bio;

    }

    public void setBio(String bio) {

        this.bio = bio;

    }

    public String getProfileImage() {

        return profileImage;

    }

    public void setProfileImage(
            String profileImage) {

        this.profileImage = profileImage;

    }

    public String getStatus() {

        return status;

    }

    public void setStatus(String status) {

        this.status = status;

    }

    public String getRejectionReason() {

        return rejectionReason;

    }

    public void setRejectionReason(
            String rejectionReason) {

        this.rejectionReason =
            rejectionReason;

    }

}