package com.mindmitra.backend.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindmitra.backend.entity.MeditationTracker;
import com.mindmitra.backend.repository.MeditationTrackerRepository;

@Service
public class MeditationTrackerService {

    @Autowired
    private MeditationTrackerRepository
            meditationTrackerRepository;

    // =========================
    // SAVE MEDITATION
    // =========================

    public MeditationTracker saveMeditation(

            MeditationTracker tracker

    ) {

        // =========================
        // SET TODAY DATE
        // =========================

        tracker.setDate(
                LocalDate.now()
        );

        // =========================
        // SET COMPLETED TRUE
        // =========================

        tracker.setCompleted(
                true
        );

        // =========================
        // CHECK ALREADY EXISTS
        // =========================

        MeditationTracker existing =

                meditationTrackerRepository
                        .findByUserEmailAndDate(

                                tracker.getUserEmail(),

                                LocalDate.now()

                        );

        // =========================
        // UPDATE EXISTING
        // =========================

        if(existing != null) {

            existing.setMinutes(
                    existing.getMinutes()
                            + tracker.getMinutes()
            );

            existing.setCompleted(true);

            return meditationTrackerRepository
                    .save(existing);

        }

        // =========================
        // SAVE NEW
        // =========================

        return meditationTrackerRepository
                .save(tracker);

    }

    // =========================
    // GET USER HISTORY
    // =========================

    public List<MeditationTracker>
    getUserMeditationHistory(

            String userEmail

    ) {

        return meditationTrackerRepository
                .findByUserEmail(
                        userEmail
                );

    }

}