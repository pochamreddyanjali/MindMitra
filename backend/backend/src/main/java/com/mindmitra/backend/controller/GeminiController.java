package com.mindmitra.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mindmitra.backend.service.GeminiService;

@RestController
@RequestMapping("/ai")
@CrossOrigin("*")
public class GeminiController {

    @Autowired
    private GeminiService geminiService;

    // =========================
    // AI CHAT
    // =========================

    @PostMapping("/chat")
    public String chat(
            @RequestBody String message) {

        return geminiService.getResponse(
                message
        );

    }

}
