package com.mindmitra.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindmitra.backend.entity.Ngo;

@Repository
public interface NgoRepository
        extends JpaRepository<Ngo, Long> {

    // FIND NGO BY EMAIL

    Ngo findByEmail(String email);

    // FIND NGOs BY STATUS

    List<Ngo> findByStatus(String status);

}
