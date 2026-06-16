package com.mindmitra.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mindmitra.backend.entity.NgoAnnouncement;
import com.mindmitra.backend.service.NgoAnnouncementService;

@RestController
@RequestMapping("/announcement")
@CrossOrigin(origins = "*")
public class NgoAnnouncementController {

    @Autowired
    private NgoAnnouncementService service;

    // =========================
    // CREATE ANNOUNCEMENT
    // =========================

    @PostMapping("/create")
    public String createAnnouncement(
            @RequestBody NgoAnnouncement announcement){

        return service.createAnnouncement(
                announcement
        );

    }

    // =========================
    // GET GROUP ANNOUNCEMENTS
    // =========================

    @GetMapping("/group/{groupId}")
    public List<NgoAnnouncement>
    getGroupAnnouncements(
            @PathVariable Long groupId){

        return service.getGroupAnnouncements(
                groupId
        );

    }

    // =========================
    // GET NGO ANNOUNCEMENTS
    // =========================

    @GetMapping("/ngo/{email}")
    public List<NgoAnnouncement>
    getNgoAnnouncements(
            @PathVariable String email){

        return service.getNgoAnnouncements(
                email
        );

    }

    // =========================
    // DELETE ANNOUNCEMENT
    // =========================

    @DeleteMapping("/delete/{id}")
    public String deleteAnnouncement(
            @PathVariable Long id){

        return service.deleteAnnouncement(id);

    }

}
