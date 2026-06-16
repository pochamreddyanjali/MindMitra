package com.mindmitra.backend.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindmitra.backend.entity.MeditationTracker;

@Repository
public interface MeditationTrackerRepository
        extends JpaRepository<MeditationTracker, Long> {

    // =========================
    // GET USER MEDITATION HISTORY
    // =========================

    List<MeditationTracker>
    findByUserEmail(
            String userEmail
    );

    // =========================
    // CHECK TODAY COMPLETED
    // =========================

    MeditationTracker
    findByUserEmailAndDate(

            String userEmail,

            LocalDate date

    );

}
