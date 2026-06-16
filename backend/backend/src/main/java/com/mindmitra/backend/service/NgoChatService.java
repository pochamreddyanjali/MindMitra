package com.mindmitra.backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindmitra.backend.entity.NgoChatMessage;
import com.mindmitra.backend.repository.NgoChatMessageRepository;

@Service
public class NgoChatService {

    @Autowired
    private NgoChatMessageRepository repo;

    // =========================
    // SEND MESSAGE
    // =========================

    public String sendMessage(
            NgoChatMessage message){

        message.setTimestamp(
                LocalDateTime.now().toString()
        );

        message.setSeen(false);

        repo.save(message);

        return "Message Sent Successfully";

    }

    // =========================
    // GET PRIVATE CHAT
    // =========================

    public List<NgoChatMessage>
    getChat(

            String sender,

            String receiver

    ){

        return repo
                .findBySenderEmailAndReceiverEmailOrReceiverEmailAndSenderEmailOrderByIdAsc(

                        sender,

                        receiver,

                        sender,

                        receiver

                );

    }

    // =========================
    // GET GROUP CHAT
    // =========================

    public List<NgoChatMessage>
    getGroupChat(
            Long groupId){

        return repo
                .findByGroupIdOrderByIdAsc(
                        groupId
                );

    }

    // =========================
    // MARK AS SEEN
    // =========================

    public String markAsSeen(

            String sender,

            String receiver

    ){

        List<NgoChatMessage> messages =

                repo
                        .findBySenderEmailAndReceiverEmailOrReceiverEmailAndSenderEmailOrderByIdAsc(

                                sender,

                                receiver,

                                sender,

                                receiver

                        );

        for(NgoChatMessage message : messages){

            if(

                    message.getSenderEmail()
                            .equals(sender)

                    &&

                    message.getReceiverEmail()
                            .equals(receiver)

                    &&

                    !message.isSeen()

            ){

                message.setSeen(true);

                repo.save(message);

            }

        }

        return "Messages Seen";

    }

    // =========================
    // GET UNREAD COUNT
    // =========================

    public long getUnreadCount(

            String sender,

            String receiver

    ){

        return repo
                .countBySenderEmailAndReceiverEmailAndSeenFalse(

                        sender,

                        receiver

                );

    }

}