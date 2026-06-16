package com.mindmitra.backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindmitra.backend.entity.Message;
import com.mindmitra.backend.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repo;

    // =========================
    // SEND MESSAGE
    // =========================

    public String sendMessage(
            Message message){

        // SET TIMESTAMP

        message.setTimestamp(
                LocalDateTime.now().toString()
        );

        // DEFAULT SEEN FALSE

        message.setSeen(false);

        repo.save(message);

        return "Message Sent";

    }

    // =========================
    // GET CHAT BETWEEN USERS
    // =========================

    public List<Message> getChat(

            String sender,

            String receiver

    ){

        return repo.getChat(

                sender,

                receiver

        );

    }

    // =========================
    // TOTAL UNREAD COUNT
    // =========================

    public long getUnreadCount(

            String receiverEmail

    ){

        return repo
            .countByReceiverEmailAndSeenFalse(

                    receiverEmail

            );

    }

    // =========================
    // UNREAD BETWEEN USERS
    // =========================

    public long getUnreadBetweenUsers(

            String sender,

            String receiver

    ){

        return repo
            .countBySenderEmailAndReceiverEmailAndSeenFalse(

                    sender,

                    receiver

            );

    }

    // =========================
    // MARK MESSAGES AS SEEN
    // =========================

    public void markMessagesAsSeen(

            String sender,

            String receiver

    ){

        repo.markMessagesAsSeen(

                sender,

                receiver

        );

    }

}