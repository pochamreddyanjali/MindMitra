package com.mindmitra.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mindmitra.backend.entity.GameScore;
import com.mindmitra.backend.service.GameScoreService;

@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "*")
public class GameScoreController {

    @Autowired
    private GameScoreService service;

    // SAVE SCORE

    @PostMapping("/save")
    public String saveScore(
            @RequestBody Map<String,String> body){

        String gameName =
            body.get("gameName");

        int score =
            Integer.parseInt(body.get("score"));

        Long userId =
            Long.parseLong(body.get("userId"));

        return service.saveScore(
                gameName,
                score,
                userId
        );

    }

    // GET BEST SCORE

    @GetMapping("/best/{userId}/{gameName}")
    public int getBestScore(

            @PathVariable Long userId,

            @PathVariable String gameName){

        return service.getBestScore(
                userId,
                gameName
        );

    }

    // GET SCORE HISTORY

    @GetMapping("/history/{userId}/{gameName}")
    public List<GameScore> getHistory(

            @PathVariable Long userId,

            @PathVariable String gameName){

        return service.getHistory(
                userId,
                gameName
        );

    }

}
