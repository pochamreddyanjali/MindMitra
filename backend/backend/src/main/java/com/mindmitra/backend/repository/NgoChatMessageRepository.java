package com.mindmitra.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindmitra.backend.entity.NgoChatMessage;

@Repository
public interface NgoChatMessageRepository
        extends JpaRepository<NgoChatMessage, Long> {

    // =========================
    // GET PRIVATE CHAT
    // =========================

    List<NgoChatMessage>

    findBySenderEmailAndReceiverEmailOrReceiverEmailAndSenderEmailOrderByIdAsc(

            String senderEmail,

            String receiverEmail,

            String receiverEmail2,

            String senderEmail2

    );

    // =========================
    // GET GROUP CHAT
    // =========================

    List<NgoChatMessage>

    findByGroupIdOrderByIdAsc(

            Long groupId

    );

    // =========================
    // GET UNSEEN MESSAGES
    // =========================

    List<NgoChatMessage>

    findByReceiverEmailAndSeenFalse(

            String receiverEmail

    );

    // =========================
    // COUNT UNREAD
    // =========================

    long countBySenderEmailAndReceiverEmailAndSeenFalse(

            String senderEmail,

            String receiverEmail

    );

}