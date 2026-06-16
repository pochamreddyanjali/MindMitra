package com.mindmitra.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mindmitra.backend.entity.Admin;
import com.mindmitra.backend.entity.Ngo;
import com.mindmitra.backend.entity.Specialist;
import com.mindmitra.backend.repository.AdminRepository;
import com.mindmitra.backend.repository.NgoRepository;
import com.mindmitra.backend.repository.SpecialistRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private SpecialistRepository specialistRepo;

    @Autowired
    private NgoRepository ngoRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ADMIN LOGIN

    public String login(String email, String password){

        Admin admin =
            adminRepo.findByEmail(email);

        if(admin == null){

            return "Invalid Email";

        }

        if(!passwordEncoder.matches(
                password,
                admin.getPassword()
        )){

            return "Invalid Password";

        }

        return "SUCCESS";

    }

    // PENDING SPECIALISTS

    public List<Specialist> getPendingSpecialists(){

        return specialistRepo.findByStatus(
            "PENDING"
        );

    }

    // APPROVE SPECIALIST

    public String approveSpecialist(Long id){

        Specialist specialist =
            specialistRepo.findById(id)
            .orElse(null);

        if(specialist == null){

            return "Specialist Not Found";

        }

        specialist.setStatus("APPROVED");

        specialist.setRejectionReason(null);

        specialistRepo.save(specialist);

        return "Specialist Approved";

    }

    // REJECT SPECIALIST

    public String rejectSpecialist(
            Long id,
            String reason){

        Specialist specialist =
            specialistRepo.findById(id)
            .orElse(null);

        if(specialist == null){

            return "Specialist Not Found";

        }

        specialist.setStatus("REJECTED");

        specialist.setRejectionReason(reason);

        specialistRepo.save(specialist);

        return "Specialist Rejected";

    }

    // PENDING NGOs

    public List<Ngo> getPendingNgos(){

        return ngoRepo.findByStatus(
            "PENDING"
        );

    }

    // APPROVE NGO

    public String approveNgo(Long id){

        Ngo ngo =
            ngoRepo.findById(id)
            .orElse(null);

        if(ngo == null){

            return "NGO Not Found";

        }

        ngo.setStatus("APPROVED");

        ngo.setRejectionReason(null);

        ngoRepo.save(ngo);

        return "NGO Approved";

    }

    // REJECT NGO

    public String rejectNgo(
            Long id,
            String reason){

        Ngo ngo =
            ngoRepo.findById(id)
            .orElse(null);

        if(ngo == null){

            return "NGO Not Found";

        }

        ngo.setStatus("REJECTED");

        ngo.setRejectionReason(reason);

        ngoRepo.save(ngo);

        return "NGO Rejected";

    }

}