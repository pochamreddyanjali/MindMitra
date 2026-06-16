package com.mindmitra.backend.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindmitra.backend.entity.GameScore;
import com.mindmitra.backend.entity.User;
import com.mindmitra.backend.repository.GameScoreRepository;
import com.mindmitra.backend.repository.UserRepository;

@Service
public class GameScoreService {

    @Autowired
    private GameScoreRepository repo;

    @Autowired
    private UserRepository userRepo;

    // SAVE SCORE

    public String saveScore(
            String gameName,
            int score,
            Long userId){

        User user =
            userRepo.findById(userId).orElse(null);

        GameScore gameScore = new GameScore();

        gameScore.setGameName(gameName);

        gameScore.setScore(score);

        gameScore.setDate(LocalDate.now());

        gameScore.setUser(user);

        repo.save(gameScore);

        return "Score Saved";

    }

    // GET BEST SCORE

 // GET BEST SCORE

    public int getBestScore(
            Long userId,
            String gameName){

        List<GameScore> scores =
            repo.findByUser_IdAndGameName(
                userId,
                gameName
        );

        if(scores.isEmpty()){

            return 0;

        }

        int best = scores.get(0).getScore();

        for(GameScore game : scores){

            if(game.getScore() > best){

                best = game.getScore();

            }

        }

        return best;

    }
    // GET SCORE HISTORY

    public List<GameScore> getHistory(
            Long userId,
            String gameName){

        return repo.findByUser_IdAndGameName(
                userId,
                gameName
        );

    }

}
