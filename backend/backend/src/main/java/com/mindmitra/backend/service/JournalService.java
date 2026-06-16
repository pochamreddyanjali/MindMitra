package com.mindmitra.backend.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindmitra.backend.entity.Journal;
import com.mindmitra.backend.entity.User;
import com.mindmitra.backend.repository.JournalRepository;
import com.mindmitra.backend.repository.UserRepository;

@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepo;

    @Autowired
    private UserRepository userRepo;

    // SAVE JOURNAL

    public String saveJournal(Journal journal, Long userId){

        User user = userRepo.findById(userId).orElse(null);

        journal.setUser(user);

        journalRepo.save(journal);

        return "Journal Saved Successfully";

    }

    // GET USER JOURNALS

    public List<Journal> getUserJournals(Long userId){

        return journalRepo.findByUser_Id(userId);

    }

    // GET JOURNALS BY DATE

    public List<Journal> getJournalsByDate(Long userId, LocalDate date){

        return journalRepo.findByUser_IdAndDate(userId, date);

    }

}