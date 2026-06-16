package com.mindmitra.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mindmitra.backend.entity.Ngo;
import com.mindmitra.backend.entity.Specialist;
import com.mindmitra.backend.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService service;

    // ADMIN LOGIN

    @PostMapping("/login")
    public String login(
            @RequestBody Map<String,String> body){

        return service.login(

            body.get("email"),
            body.get("password")

        );

    }

    // PENDING SPECIALISTS

    @GetMapping("/pending-specialists")
    public List<Specialist>
        getPendingSpecialists(){

        return service.getPendingSpecialists();

    }

    // APPROVE SPECIALIST

    @PutMapping("/approve-specialist/{id}")
    public String approveSpecialist(
            @PathVariable Long id){

        return service.approveSpecialist(id);

    }

    // REJECT SPECIALIST

    @PutMapping("/reject-specialist/{id}")
    public String rejectSpecialist(
            @PathVariable Long id,
            @RequestBody Map<String,String> body){

        return service.rejectSpecialist(

            id,
            body.get("reason")

        );

    }

    // PENDING NGOs

    @GetMapping("/pending-ngos")
    public List<Ngo>
        getPendingNgos(){

        return service.getPendingNgos();

    }

    // APPROVE NGO

    @PutMapping("/approve-ngo/{id}")
    public String approveNgo(
            @PathVariable Long id){

        return service.approveNgo(id);

    }

    // REJECT NGO

    @PutMapping("/reject-ngo/{id}")
    public String rejectNgo(
            @PathVariable Long id,
            @RequestBody Map<String,String> body){

        return service.rejectNgo(

            id,
            body.get("reason")

        );

    }

}