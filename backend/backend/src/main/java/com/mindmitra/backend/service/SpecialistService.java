package com.mindmitra.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mindmitra.backend.entity.Specialist;
import com.mindmitra.backend.repository.SpecialistRepository;

@Service
public class SpecialistService {

    @Autowired
    private SpecialistRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // REGISTER

    public String register(
            Specialist specialist){

        Specialist existing =
            repo.findByEmail(
                specialist.getEmail()
            );

        if(existing != null){

            return "Email Already Exists";

        }

        specialist.setPassword(

            passwordEncoder.encode(
                specialist.getPassword()
            )

        );

        specialist.setStatus("PENDING");

        repo.save(specialist);

        return "Registration Submitted Successfully";

    }

    // LOGIN

    public String login(
            String email,
            String password){

        Specialist specialist =
            repo.findByEmail(email);

        if(specialist == null){

            return "Invalid Email";

        }

        if(!passwordEncoder.matches(
                password,
                specialist.getPassword()
        )){

            return "Invalid Password";

        }

        // PENDING

        if(specialist.getStatus()
                .equals("PENDING")){

            return "PENDING";

        }

        // REJECTED

        if(specialist.getStatus()
                .equals("REJECTED")){

            return "REJECTED : "
                    + specialist
                    .getRejectionReason();

        }

        return "SUCCESS";

    }

    // GET APPROVED SPECIALISTS

    public List<Specialist>
        getApprovedSpecialists(){

        return repo.findByStatus(
            "APPROVED"
        );

    }

    // GET PROFILE

    public Specialist getProfile(
            String email){

        return repo.findByEmail(email);

    }

    // UPDATE PROFILE

    public String updateProfile(
            Specialist updatedSpecialist){

        Specialist specialist =
            repo.findByEmail(
                updatedSpecialist.getEmail()
            );

        if(specialist == null){

            return "Specialist Not Found";

        }

        specialist.setName(
            updatedSpecialist.getName()
        );

        specialist.setPhone(
            updatedSpecialist.getPhone()
        );

        specialist.setSpecialization(
            updatedSpecialist.getSpecialization()
        );

        specialist.setQualification(
            updatedSpecialist.getQualification()
        );

        specialist.setExperience(
            updatedSpecialist.getExperience()
        );

        specialist.setBio(
            updatedSpecialist.getBio()
        );

        // SAVE PROFILE IMAGE

        specialist.setProfileImage(
            updatedSpecialist.getProfileImage()
        );

        repo.save(specialist);

        return "Profile Updated Successfully";

    }

}