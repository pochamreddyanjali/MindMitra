package com.mindmitra.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindmitra.backend.entity.NgoPoll;

@Repository
public interface NgoPollRepository
        extends JpaRepository<NgoPoll, Long> {

    // =========================
    // GET POLLS BY GROUP
    // =========================

    List<NgoPoll>
    findByGroupIdOrderByIdDesc(
            Long groupId
    );

    // =========================
    // GET POLLS BY NGO
    // =========================

    List<NgoPoll>
    findByNgoEmailOrderByIdDesc(
            String ngoEmail
    );

}