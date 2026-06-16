package com.mindmitra.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mindmitra.backend.entity.NgoPoll;
import com.mindmitra.backend.entity.PollVote;
import com.mindmitra.backend.service.NgoPollService;

@RestController
@RequestMapping("/poll")
@CrossOrigin(origins = "*")
public class NgoPollController {

    @Autowired
    private NgoPollService service;

    // =========================
    // CREATE POLL
    // =========================

    @PostMapping("/create")
    public String createPoll(
            @RequestBody NgoPoll poll){

        return service.createPoll(poll);

    }

    // =========================
    // GET GROUP POLLS
    // =========================

    @GetMapping("/group/{groupId}")
    public List<NgoPoll>
    getGroupPolls(
            @PathVariable Long groupId){

        return service.getGroupPolls(groupId);

    }

    // =========================
    // GET NGO POLLS
    // =========================

    @GetMapping("/ngo/{email}")
    public List<NgoPoll>
    getNgoPolls(
            @PathVariable String email){

        return service.getNgoPolls(email);

    }

    // =========================
    // VOTE POLL
    // =========================

    @PostMapping("/vote")
    public String votePoll(
            @RequestBody PollVote vote){

        return service.votePoll(vote);

    }

    // =========================
    // GET POLL RESULTS
    // =========================

    @GetMapping("/results/{pollId}")
    public Map<String, Long>
    getPollResults(
            @PathVariable Long pollId){

        return service.getPollResults(
                pollId
        );

    }

    // =========================
    // DELETE POLL
    // =========================

    @DeleteMapping("/delete/{id}")
    public String deletePoll(
            @PathVariable Long id){

        return service.deletePoll(id);

    }

}