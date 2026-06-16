package com.mindmitra.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mindmitra.backend.entity.NgoChatMessage;
import com.mindmitra.backend.service.NgoChatService;

@RestController
@RequestMapping("/ngo-chat")
@CrossOrigin(origins = "*")
public class NgoChatController {

    @Autowired
    private NgoChatService service;

    // =========================
    // SEND MESSAGE
    // =========================

    @PostMapping("/send")
    public String sendMessage(
            @RequestBody NgoChatMessage message){

        return service.sendMessage(
                message
        );

    }

    // =========================
    // GET PRIVATE CHAT
    // =========================

    @GetMapping("/chat")
    public List<NgoChatMessage> getChat(

            @RequestParam String sender,

            @RequestParam String receiver

    ){

        return service.getChat(

                sender,

                receiver

        );

    }

    // =========================
    // GET GROUP CHAT
    // =========================

    @GetMapping("/group/{groupId}")
    public List<NgoChatMessage>
    getGroupChat(
            @PathVariable Long groupId){

        return service.getGroupChat(
                groupId
        );

    }

    // =========================
    // MARK AS SEEN
    // =========================

    @PutMapping("/seen")
    public String markAsSeen(

            @RequestParam String sender,

            @RequestParam String receiver

    ){

        return service.markAsSeen(

                sender,

                receiver

        );

    }

    // =========================
    // GET UNREAD COUNT
    // =========================

    @GetMapping("/unread")
    public long getUnreadCount(

            @RequestParam String sender,

            @RequestParam String receiver

    ){

        return service.getUnreadCount(

                sender,

                receiver

        );

    }

}