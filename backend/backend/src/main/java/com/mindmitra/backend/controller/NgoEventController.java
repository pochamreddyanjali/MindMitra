package com.mindmitra.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mindmitra.backend.entity.NgoEvent;
import com.mindmitra.backend.service.NgoEventService;

@RestController
@RequestMapping("/ngo-event")
@CrossOrigin(origins = "*")
public class NgoEventController {

    @Autowired
    private NgoEventService service;

    // =========================
    // CREATE EVENT
    // =========================

    @PostMapping("/create")
    public String createEvent(
            @RequestBody NgoEvent event){

        return service.createEvent(event);

    }

    // =========================
    // GET GROUP EVENTS
    // =========================

    @GetMapping("/group/{groupId}")
    public List<NgoEvent>
    getGroupEvents(
            @PathVariable Long groupId){

        return service.getGroupEvents(groupId);

    }

    // =========================
    // GET NGO EVENTS
    // =========================

    @GetMapping("/ngo/{email}")
    public List<NgoEvent>
    getNgoEvents(
            @PathVariable String email){

        return service.getNgoEvents(email);

    }

    // =========================
    // SEARCH EVENTS
    // =========================

    @GetMapping("/search")
    public List<NgoEvent>
    searchEvents(
            @RequestParam String keyword){

        return service.searchEvents(keyword);

    }

    // =========================
    // DELETE EVENT
    // =========================

    @DeleteMapping("/delete/{id}")
    public String deleteEvent(
            @PathVariable Long id){

        return service.deleteEvent(id);

    }

}