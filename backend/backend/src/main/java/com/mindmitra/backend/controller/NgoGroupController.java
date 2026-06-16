package com.mindmitra.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mindmitra.backend.entity.GroupMember;
import com.mindmitra.backend.entity.NgoGroup;
import com.mindmitra.backend.service.NgoGroupService;

@RestController
@RequestMapping("/ngo-group")
@CrossOrigin(origins = "*")
public class NgoGroupController {

    @Autowired
    private NgoGroupService service;

    // =========================
    // CREATE GROUP
    // =========================

    @PostMapping("/create")
    public String createGroup(
            @RequestBody NgoGroup group){

        return service.createGroup(group);

    }

    // =========================
    // GET ALL GROUPS
    // =========================

    @GetMapping("/all")
    public List<NgoGroup> getAllGroups(){

        return service.getAllGroups();

    }

    // =========================
    // GET NGO GROUPS
    // =========================

    @GetMapping("/ngo/{email}")
    public List<NgoGroup>
    getNgoGroups(
            @PathVariable String email){

        return service.getNgoGroups(email);

    }

    // =========================
    // GET PUBLIC GROUPS
    // =========================

    @GetMapping("/public")
    public List<NgoGroup>
    getPublicGroups(){

        return service.getPublicGroups();

    }

    // =========================
    // SEARCH GROUPS
    // =========================

    @GetMapping("/search")
    public List<NgoGroup>
    searchGroups(
            @RequestParam String keyword){

        return service.searchGroups(keyword);

    }

    // =========================
    // JOIN GROUP
    // =========================

    @PostMapping("/join")
    public String joinGroup(
            @RequestBody GroupMember member){

        return service.joinGroup(member);

    }

    // =========================
    // APPROVE REQUEST
    // =========================

    @PutMapping("/approve/{id}")
    public String approveRequest(
            @PathVariable Long id){

        return service.approveRequest(id);

    }

    // =========================
    // REJECT REQUEST
    // =========================

    @PutMapping("/reject/{id}")
    public String rejectRequest(
            @PathVariable Long id){

        return service.rejectRequest(id);

    }

    // =========================
    // GET PENDING REQUESTS
    // =========================

    @GetMapping("/pending/{ngoEmail}")
    public List<GroupMember>
    getPendingRequests(
            @PathVariable String ngoEmail){

        return service.getPendingRequests(
                ngoEmail
        );

    }

    // =========================
    // LEAVE GROUP
    // =========================

    @DeleteMapping("/leave")
    public String leaveGroup(

            @RequestParam Long groupId,

            @RequestParam String userEmail

    ){

        return service.leaveGroup(

                groupId,

                userEmail

        );

    }

    // =========================
    // GET GROUP MEMBERS
    // =========================

    @GetMapping("/members/{groupId}")
    public List<GroupMember>
    getGroupMembers(
            @PathVariable Long groupId){

        return service.getGroupMembers(groupId);

    }

    // =========================
    // GET USER GROUPS
    // =========================

    @GetMapping("/user/{email}")
    public List<GroupMember>
    getUserGroups(
            @PathVariable String email){

        return service.getUserGroups(email);

    }

}