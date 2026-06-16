package com.mindmitra.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindmitra.backend.entity.GameScore;

@Repository
public interface GameScoreRepository
        extends JpaRepository<GameScore, Long>{

    // GET ALL SCORES OF USER FOR PARTICULAR GAME

    List<GameScore> findByUser_IdAndGameName(
            Long userId,
            String gameName
    );

}