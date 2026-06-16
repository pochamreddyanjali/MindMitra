package com.mindmitra.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mindmitra.backend.entity.Specialist;
import com.mindmitra.backend.service.SpecialistService;

@RestController
@RequestMapping("/specialist")
@CrossOrigin(origins = "*")
public class SpecialistController {

    @Autowired
    private SpecialistService service;

    // REGISTER

    @PostMapping("/register")
    public String register(
            @RequestBody Specialist specialist){

        return service.register(specialist);

    }

    // LOGIN

    @PostMapping("/login")
    public String login(
            @RequestBody Map<String,String> body){

        return service.login(

            body.get("email"),
            body.get("password")

        );

    }

    // GET APPROVED SPECIALISTS

    @GetMapping("/all-approved")
    public List<Specialist>
        getApprovedSpecialists(){

        return service
                .getApprovedSpecialists();

    }

    // GET PROFILE

    @GetMapping("/profile/{email}")
    public Specialist getProfile(
            @PathVariable String email){

        return service.getProfile(email);

    }

    // UPDATE PROFILE

    @PutMapping("/update-profile")
    public String updateProfile(
            @RequestBody Specialist specialist){

        return service.updateProfile(
            specialist
        );

    }

}