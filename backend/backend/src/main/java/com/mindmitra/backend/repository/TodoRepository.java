package com.mindmitra.backend.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindmitra.backend.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    // GET ALL TASKS OF USER

    List<Todo> findByUser_Id(Long userId);

    // GET TASKS BY DATE

    List<Todo> findByUser_IdAndDate(Long userId, LocalDate date);

    // GET COMPLETED TASKS

    List<Todo> findByUser_IdAndCompleted(Long userId, boolean completed);

}
