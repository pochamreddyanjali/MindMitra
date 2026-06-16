package com.mindmitra.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindmitra.backend.entity.Specialist;

@Repository
public interface SpecialistRepository
        extends JpaRepository<Specialist, Long> {

    // FIND BY EMAIL

    Specialist findByEmail(String email);

    // FIND BY STATUS

    List<Specialist> findByStatus(String status);

}
