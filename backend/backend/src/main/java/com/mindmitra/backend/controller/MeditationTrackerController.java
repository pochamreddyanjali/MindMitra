package com.mindmitra.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mindmitra.backend.entity.MeditationTracker;
import com.mindmitra.backend.service.MeditationTrackerService;

@RestController
@RequestMapping("/meditation")
@CrossOrigin("*")
public class MeditationTrackerController {

    @Autowired
    private MeditationTrackerService
            meditationTrackerService;

    // =========================
    // SAVE MEDITATION
    // =========================

    @PostMapping("/save")
    public MeditationTracker saveMeditation(

            @RequestBody MeditationTracker tracker

    ) {

        return meditationTrackerService
                .saveMeditation(
                        tracker
                );

    }

    // =========================
    // GET USER HISTORY
    // =========================

    @GetMapping("/history/{userEmail}")
    public List<MeditationTracker>
    getUserMeditationHistory(

            @PathVariable
            String userEmail

    ) {

        return meditationTrackerService
                .getUserMeditationHistory(
                        userEmail
                );

    }

}
