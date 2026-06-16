package com.mindmitra.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mindmitra.backend.entity.Ngo;
import com.mindmitra.backend.entity.NgoFollower;
import com.mindmitra.backend.service.NgoFollowerService;

@RestController
@RequestMapping("/ngo-follower")
@CrossOrigin(origins = "*")
public class NgoFollowerController {

    @Autowired
    private NgoFollowerService service;

    // =========================
    // JOIN NGO
    // =========================

    @PostMapping("/join")
    public String joinNgo(
            @RequestBody NgoFollower follower){

        return service.joinNgo(
            follower
        );

    }

    // =========================
    // LEAVE NGO
    // =========================

    @DeleteMapping("/leave")
    public String leaveNgo(
            @RequestBody Map<String,String> body){

        return service.leaveNgo(

            body.get("userEmail"),
            body.get("ngoEmail")

        );

    }

    // =========================
    // GET USER NGOs
    // =========================

    @GetMapping("/user/{userEmail}")
    public List<Ngo> getUserNgos(
            @PathVariable String userEmail){

        return service.getUserNgos(
            userEmail
        );

    }

    // =========================
    // GET NGO FOLLOWERS
    // =========================

    @GetMapping("/ngo/{ngoEmail}")
    public List<NgoFollower> getNgoFollowers(
            @PathVariable String ngoEmail){

        return service.getNgoFollowers(
            ngoEmail
        );

    }

}