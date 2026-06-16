package com.mindmitra.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mindmitra.backend.entity.Ngo;
import com.mindmitra.backend.service.NgoService;

@RestController
@RequestMapping("/ngo")
@CrossOrigin(origins = "*")
public class NgoController {

    @Autowired
    private NgoService service;

    // =========================
    // REGISTER NGO
    // =========================

    @PostMapping("/register")
    public String register(
            @RequestBody Ngo ngo){

        return service.register(ngo);

    }

    // =========================
    // LOGIN NGO
    // =========================

    @PostMapping("/login")
    public String login(
            @RequestBody Map<String,String> body){

        return service.login(

            body.get("email"),
            body.get("password")

        );

    }

    // =========================
    // GET APPROVED NGOs
    // =========================

    @GetMapping("/all-approved")
    public List<Ngo>
    getApprovedNgos(){

        return service.getApprovedNgos();

    }

    // =========================
    // GET NGO BY EMAIL
    // =========================

    @GetMapping("/get/{email}")
    public Ngo getNgoByEmail(
            @PathVariable String email){

        return service.getNgoByEmail(
                email
        );

    }

}