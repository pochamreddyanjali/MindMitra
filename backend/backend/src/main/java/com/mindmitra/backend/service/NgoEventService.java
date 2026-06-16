package com.mindmitra.backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindmitra.backend.entity.NgoEvent;
import com.mindmitra.backend.repository.NgoEventRepository;

@Service
public class NgoEventService {

    @Autowired
    private NgoEventRepository repo;

    // =========================
    // CREATE EVENT
    // =========================

    public String createEvent(
            NgoEvent event){

        event.setCreatedAt(
                LocalDateTime.now().toString()
        );

        repo.save(event);

        return "NGO Event Created Successfully";

    }

    // =========================
    // GET GROUP EVENTS
    // =========================

    public List<NgoEvent>
    getGroupEvents(
            Long groupId){

        return repo.findByGroupIdOrderByIdDesc(
                groupId
        );

    }

    // =========================
    // GET NGO EVENTS
    // =========================

    public List<NgoEvent>
    getNgoEvents(
            String ngoEmail){

        return repo.findByNgoEmailOrderByIdDesc(
                ngoEmail
        );

    }

    // =========================
    // SEARCH EVENTS
    // =========================

    public List<NgoEvent>
    searchEvents(
            String keyword){

        return repo.findByTitleContainingIgnoreCase(
                keyword
        );

    }

    // =========================
    // DELETE EVENT
    // =========================

    public String deleteEvent(
            Long id){

        repo.deleteById(id);

        return "Event Deleted Successfully";

    }

}