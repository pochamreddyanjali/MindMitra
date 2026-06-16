package com.mindmitra.backend.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mindmitra.backend.entity.Journal;
import com.mindmitra.backend.service.JournalService;

@RestController
@RequestMapping("/journal")
@CrossOrigin(origins = "*")
public class JournalController {

    @Autowired
    private JournalService service;

    @PostMapping("/save")
    public String saveJournal(@RequestBody Map<String, String> body){

        Journal journal = new Journal();

        journal.setTitle(body.get("title"));
        journal.setContent(body.get("content"));
        journal.setMood(body.get("mood"));
        journal.setGratitude(body.get("gratitude"));

        // SAVE DATE

        journal.setDate(LocalDate.parse(body.get("date")));

        Long userId = Long.parseLong(body.get("userId"));

        return service.saveJournal(journal, userId);

    }

    @GetMapping("/user/{id}")
    public List<Journal> getUserJournals(@PathVariable Long id){

        return service.getUserJournals(id);

    }

    // SEARCH JOURNALS BY DATE

    @GetMapping("/user/{userId}/{date}")
    public List<Journal> getJournalsByDate(
            @PathVariable Long userId,
            @PathVariable LocalDate date){

        return service.getJournalsByDate(userId, date);

    }

}