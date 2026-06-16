package com.mindmitra.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindmitra.backend.entity.NgoGroup;

@Repository
public interface NgoGroupRepository
        extends JpaRepository<NgoGroup, Long> {

    // =========================
    // GET NGO GROUPS BY NGO EMAIL
    // =========================

    List<NgoGroup>
    findByNgoEmail(
            String ngoEmail
    );

    // =========================
    // GET GROUPS BY PRIVACY
    // =========================

    List<NgoGroup>
    findByPrivacy(
            String privacy
    );

    // =========================
    // SEARCH GROUPS BY NAME
    // =========================

    List<NgoGroup>
    findByGroupNameContainingIgnoreCase(
            String groupName
    );

}