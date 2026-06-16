package com.mindmitra.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindmitra.backend.entity.Ngo;
import com.mindmitra.backend.entity.NgoFollower;
import com.mindmitra.backend.repository.NgoFollowerRepository;
import com.mindmitra.backend.repository.NgoRepository;

@Service
public class NgoFollowerService {

    @Autowired
    private NgoFollowerRepository followerRepo;

    @Autowired
    private NgoRepository ngoRepo;

    // =========================
    // JOIN NGO
    // =========================

    public String joinNgo(
            NgoFollower follower){

        NgoFollower existing =

            followerRepo
            .findByUserEmailAndNgoEmail(

                follower.getUserEmail(),
                follower.getNgoEmail()

            );

        if(existing != null){

            return "Already Joined NGO";

        }

        followerRepo.save(follower);

        return "NGO Joined Successfully";

    }

    // =========================
    // LEAVE NGO
    // =========================

    public String leaveNgo(
            String userEmail,
            String ngoEmail){

        NgoFollower existing =

            followerRepo
            .findByUserEmailAndNgoEmail(

                userEmail,
                ngoEmail

            );

        if(existing == null){

            return "NGO Follow Not Found";

        }

        followerRepo
        .deleteByUserEmailAndNgoEmail(

            userEmail,
            ngoEmail

        );

        return "Left NGO Successfully";

    }

    // =========================
    // GET USER NGOs
    // =========================

    public List<Ngo> getUserNgos(
            String userEmail){

        List<NgoFollower> followers =

            followerRepo.findByUserEmail(
                userEmail
            );

        List<Ngo> ngos =
            new ArrayList<>();

        for(NgoFollower f : followers){

            Ngo ngo =
                ngoRepo.findByEmail(
                    f.getNgoEmail()
                );

            if(ngo != null){

                ngos.add(ngo);

            }

        }

        return ngos;

    }

    // =========================
    // GET NGO FOLLOWERS
    // =========================

    public List<NgoFollower> getNgoFollowers(
            String ngoEmail){

        return followerRepo.findByNgoEmail(
            ngoEmail
        );

    }

}