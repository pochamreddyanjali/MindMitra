package com.mindmitra.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mindmitra.backend.entity.Ngo;
import com.mindmitra.backend.repository.NgoRepository;

@Service
public class NgoService {

    @Autowired
    private NgoRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // =========================
    // REGISTER NGO
    // =========================

    public String register(
            Ngo ngo){

        Ngo existing =
            repo.findByEmail(
                ngo.getEmail()
            );

        if(existing != null){

            return "Email Already Exists";

        }

        ngo.setPassword(

            passwordEncoder.encode(
                ngo.getPassword()
            )

        );

        ngo.setStatus("PENDING");

        repo.save(ngo);

        return "NGO Registration Submitted";

    }

    // =========================
    // LOGIN NGO
    // =========================

    public String login(
            String email,
            String password){

        Ngo ngo =
            repo.findByEmail(email);

        if(ngo == null){

            return "Invalid Email";

        }

        if(!passwordEncoder.matches(
                password,
                ngo.getPassword()
        )){

            return "Invalid Password";

        }

        // PENDING

        if(ngo.getStatus()
                .equals("PENDING")){

            return "PENDING";

        }

        // REJECTED

        if(ngo.getStatus()
                .equals("REJECTED")){

            return "REJECTED : "
                    + ngo
                    .getRejectionReason();

        }

        return "SUCCESS";

    }

    // =========================
    // GET APPROVED NGOs
    // =========================

    public List<Ngo>
        getApprovedNgos(){

        return repo.findByStatus(
            "APPROVED"
        );

    }

    // =========================
    // GET NGO BY EMAIL
    // =========================

    public Ngo getNgoByEmail(
            String email){

        return repo.findByEmail(
            email
        );

    }

}