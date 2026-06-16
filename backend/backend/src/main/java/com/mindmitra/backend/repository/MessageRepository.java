package com.mindmitra.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindmitra.backend.entity.Message;

import jakarta.transaction.Transactional;

@Repository
public interface MessageRepository
        extends JpaRepository<Message, Long> {

    // =========================
    // GET CHAT BETWEEN USERS
    // =========================

    @Query(

        "SELECT m FROM Message m WHERE " +

        "(m.senderEmail = ?1 AND m.receiverEmail = ?2) " +

        "OR " +

        "(m.senderEmail = ?2 AND m.receiverEmail = ?1) " +

        "ORDER BY m.id ASC"

    )

    List<Message> getChat(

            String sender,

            String receiver

    );

    // =========================
    // COUNT UNREAD MESSAGES
    // =========================

    long countByReceiverEmailAndSeenFalse(

            String receiverEmail

    );

    // =========================
    // COUNT UNREAD BETWEEN USERS
    // =========================

    long countBySenderEmailAndReceiverEmailAndSeenFalse(

            String senderEmail,

            String receiverEmail

    );

    // =========================
    // MARK AS SEEN
    // =========================

    @Transactional
    @Modifying

    @Query(

        "UPDATE Message m SET m.seen = true " +

        "WHERE m.senderEmail = ?1 " +

        "AND m.receiverEmail = ?2"

    )

    void markMessagesAsSeen(

            String sender,

            String receiver

    );

}