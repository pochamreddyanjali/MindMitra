package com.mindmitra.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindmitra.backend.entity.PollVote;

@Repository
public interface PollVoteRepository
        extends JpaRepository<PollVote, Long> {

    // =========================
    // GET VOTES OF POLL
    // =========================

    List<PollVote>
    findByPollId(
            Long pollId
    );

    // =========================
    // CHECK USER ALREADY VOTED
    // =========================

    PollVote
    findByPollIdAndUserEmail(

            Long pollId,

            String userEmail

    );

    // =========================
    // COUNT OPTION VOTES
    // =========================

    long countByPollIdAndSelectedOption(

            Long pollId,

            String selectedOption

    );

}
