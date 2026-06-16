package com.mindmitra.backend.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindmitra.backend.entity.Journal;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {

    List<Journal> findByUser_Id(Long userId);

    // NEW DATE SEARCH METHOD

    List<Journal> findByUser_IdAndDate(Long userId, LocalDate date);

}