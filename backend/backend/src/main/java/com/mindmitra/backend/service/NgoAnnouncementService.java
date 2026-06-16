package com.mindmitra.backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindmitra.backend.entity.NgoAnnouncement;
import com.mindmitra.backend.repository.NgoAnnouncementRepository;

@Service
public class NgoAnnouncementService {

    @Autowired
    private NgoAnnouncementRepository repo;

    // =========================
    // CREATE ANNOUNCEMENT
    // =========================

    public String createAnnouncement(
            NgoAnnouncement announcement){

        announcement.setCreatedAt(
                LocalDateTime.now().toString()
        );

        repo.save(announcement);

        return "Announcement Posted Successfully";

    }

    // =========================
    // GET GROUP ANNOUNCEMENTS
    // =========================

    public List<NgoAnnouncement>
    getGroupAnnouncements(
            Long groupId){

        return repo.findByGroupIdOrderByIdDesc(
                groupId
        );

    }

    // =========================
    // GET NGO ANNOUNCEMENTS
    // =========================

    public List<NgoAnnouncement>
    getNgoAnnouncements(
            String ngoEmail){

        return repo.findByNgoEmailOrderByIdDesc(
                ngoEmail
        );

    }

    // =========================
    // DELETE ANNOUNCEMENT
    // =========================

    public String deleteAnnouncement(
            Long id){

        repo.deleteById(id);

        return "Announcement Deleted Successfully";

    }

}