package com.mindmitra.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindmitra.backend.entity.NgoAnnouncement;

@Repository
public interface NgoAnnouncementRepository
        extends JpaRepository<NgoAnnouncement, Long> {

    // =========================
    // GET ANNOUNCEMENTS BY GROUP
    // =========================

    List<NgoAnnouncement>
    findByGroupIdOrderByIdDesc(
            Long groupId
    );

    // =========================
    // GET ANNOUNCEMENTS BY NGO
    // =========================

    List<NgoAnnouncement>
    findByNgoEmailOrderByIdDesc(
            String ngoEmail
    );

}
