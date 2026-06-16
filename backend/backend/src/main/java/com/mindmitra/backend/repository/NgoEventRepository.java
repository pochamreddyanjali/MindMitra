package com.mindmitra.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindmitra.backend.entity.NgoEvent;

@Repository
public interface NgoEventRepository
        extends JpaRepository<NgoEvent, Long> {

    // =========================
    // GET EVENTS BY GROUP
    // =========================

    List<NgoEvent>
    findByGroupIdOrderByIdDesc(
            Long groupId
    );

    // =========================
    // GET EVENTS BY NGO
    // =========================

    List<NgoEvent>
    findByNgoEmailOrderByIdDesc(
            String ngoEmail
    );

    // =========================
    // SEARCH EVENTS BY TITLE
    // =========================

    List<NgoEvent>
    findByTitleContainingIgnoreCase(
            String title
    );

}