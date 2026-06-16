package com.mindmitra.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindmitra.backend.entity.NgoFollower;

@Repository
public interface NgoFollowerRepository
        extends JpaRepository<NgoFollower, Long> {

    // =========================
    // FIND BY USER EMAIL
    // =========================

    List<NgoFollower> findByUserEmail(
            String userEmail
    );

    // =========================
    // FIND BY NGO EMAIL
    // =========================

    List<NgoFollower> findByNgoEmail(
            String ngoEmail
    );

    // =========================
    // FIND BY USER + NGO
    // =========================

    NgoFollower findByUserEmailAndNgoEmail(
            String userEmail,
            String ngoEmail
    );

    // =========================
    // DELETE BY USER + NGO
    // =========================

    void deleteByUserEmailAndNgoEmail(
            String userEmail,
            String ngoEmail
    );

}