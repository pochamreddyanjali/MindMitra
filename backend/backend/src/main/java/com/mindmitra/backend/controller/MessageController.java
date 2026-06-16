package com.mindmitra.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mindmitra.backend.entity.Message;
import com.mindmitra.backend.service.MessageService;

@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "*")
public class MessageController {

    @Autowired
    private MessageService service;

    // =========================
    // SEND MESSAGE
    // =========================

    @PostMapping("/send")
    public String sendMessage(
            @RequestBody Message message){

        return service.sendMessage(
                message
        );

    }

    // =========================
    // GET CHAT
    // =========================

    @GetMapping("/chat")
    public List<Message> getChat(

            @RequestParam String sender,

            @RequestParam String receiver

    ){

        return service.getChat(

                sender,

                receiver

        );

    }

    // =========================
    // TOTAL UNREAD COUNT
    // =========================

    @GetMapping("/unread/{email}")
    public long getUnreadCount(

            @PathVariable String email

    ){

        return service.getUnreadCount(
                email
        );

    }

    // =========================
    // UNREAD BETWEEN USERS
    // =========================

    @GetMapping("/unread-between")
    public long getUnreadBetweenUsers(

            @RequestParam String sender,

            @RequestParam String receiver

    ){

        return service.getUnreadBetweenUsers(

                sender,

                receiver

        );

    }

    // =========================
    // MARK AS SEEN
    // =========================

    @PutMapping("/seen")
    public void markMessagesAsSeen(

            @RequestParam String sender,

            @RequestParam String receiver

    ){

        service.markMessagesAsSeen(

                sender,

                receiver

        );

    }

}