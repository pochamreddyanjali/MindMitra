package com.mindmitra.backend.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindmitra.backend.entity.NgoPoll;
import com.mindmitra.backend.entity.PollVote;
import com.mindmitra.backend.repository.NgoPollRepository;
import com.mindmitra.backend.repository.PollVoteRepository;

@Service
public class NgoPollService {

    @Autowired
    private NgoPollRepository pollRepo;

    @Autowired
    private PollVoteRepository voteRepo;

    // =========================
    // CREATE POLL
    // =========================

    public String createPoll(
            NgoPoll poll){

        poll.setCreatedAt(
                LocalDateTime.now().toString()
        );

        pollRepo.save(poll);

        return "Poll Created Successfully";

    }

    // =========================
    // GET GROUP POLLS
    // =========================

    public List<NgoPoll>
    getGroupPolls(
            Long groupId){

        return pollRepo
                .findByGroupIdOrderByIdDesc(
                        groupId
                );

    }

    // =========================
    // GET NGO POLLS
    // =========================

    public List<NgoPoll>
    getNgoPolls(
            String ngoEmail){

        return pollRepo
                .findByNgoEmailOrderByIdDesc(
                        ngoEmail
                );

    }

    // =========================
    // VOTE POLL
    // =========================

    public String votePoll(
            PollVote vote){

        PollVote existing =

                voteRepo
                        .findByPollIdAndUserEmail(

                                vote.getPollId(),

                                vote.getUserEmail()

                        );

        if(existing != null){

            return "User Already Voted";

        }

        vote.setVotedAt(
                LocalDateTime.now().toString()
        );

        voteRepo.save(vote);

        return "Vote Submitted Successfully";

    }

    // =========================
    // GET POLL RESULTS
    // =========================

    public Map<String, Long>
    getPollResults(
            Long pollId){

        Map<String, Long> results =
                new HashMap<>();

        List<PollVote> votes =
                voteRepo.findByPollId(
                        pollId
                );

        for(PollVote vote : votes){

            String option =
                    vote.getSelectedOption();

            results.put(

                    option,

                    results.getOrDefault(
                            option,
                            0L
                    ) + 1

            );

        }

        return results;

    }

    // =========================
    // DELETE POLL
    // =========================

    public String deletePoll(
            Long id){

        pollRepo.deleteById(id);

        return "Poll Deleted Successfully";

    }

}