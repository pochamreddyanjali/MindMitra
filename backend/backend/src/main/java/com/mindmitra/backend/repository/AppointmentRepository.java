package com.mindmitra.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindmitra.backend.entity.Appointment;

@Repository
public interface AppointmentRepository
        extends JpaRepository<Appointment, Long> {

    // =========================
    // GET APPOINTMENTS OF SPECIALIST
    // =========================

    List<Appointment> findBySpecialistEmail(
            String specialistEmail);

    // =========================
    // GET APPOINTMENTS OF USER
    // =========================

    List<Appointment> findByUserEmail(
            String userEmail);

    // =========================
    // GET PENDING REQUESTS
    // =========================

    List<Appointment> findBySpecialistEmailAndStatus(
            String specialistEmail,
            String status);

    // =========================
    // GET USER REQUESTS BY STATUS
    // =========================

    List<Appointment> findByUserEmailAndStatus(
            String userEmail,
            String status);

}