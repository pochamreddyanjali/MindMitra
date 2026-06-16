package com.mindmitra.backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindmitra.backend.entity.GroupMember;
import com.mindmitra.backend.entity.NgoGroup;
import com.mindmitra.backend.repository.GroupMemberRepository;
import com.mindmitra.backend.repository.NgoGroupRepository;

@Service
public class NgoGroupService {

    @Autowired
    private NgoGroupRepository groupRepo;

    @Autowired
    private GroupMemberRepository memberRepo;

    // =========================
    // CREATE GROUP
    // =========================

    public String createGroup(
            NgoGroup group){

        group.setCreatedAt(
                LocalDateTime.now().toString()
        );

        groupRepo.save(group);

        return "NGO Group Created Successfully";

    }

    // =========================
    // GET ALL GROUPS
    // =========================

    public List<NgoGroup> getAllGroups(){

        return groupRepo.findAll();

    }

    // =========================
    // GET NGO GROUPS
    // =========================

    public List<NgoGroup>
    getNgoGroups(
            String ngoEmail){

        return groupRepo.findByNgoEmail(
                ngoEmail
        );

    }

    // =========================
    // GET PUBLIC GROUPS
    // =========================

    public List<NgoGroup>
    getPublicGroups(){

        return groupRepo.findByPrivacy(
                "PUBLIC"
        );

    }

    // =========================
    // SEARCH GROUPS
    // =========================

    public List<NgoGroup>
    searchGroups(
            String keyword){

        return groupRepo
                .findByGroupNameContainingIgnoreCase(
                        keyword
                );

    }

    // =========================
    // JOIN GROUP
    // =========================

    public String joinGroup(
            GroupMember member){

        GroupMember existing =

                memberRepo
                        .findByGroupIdAndUserEmail(

                                member.getGroupId(),

                                member.getUserEmail()

                        );

        if(existing != null){

            return "User Already Joined This Group";

        }

        NgoGroup group =
                groupRepo.findById(
                        member.getGroupId()
                ).orElse(null);

        if(group == null){

            return "Group Not Found";

        }

        member.setJoinedAt(
                LocalDateTime.now().toString()
        );

        if(group.getPrivacy()
                .equalsIgnoreCase("PUBLIC")){

            member.setStatus(
                    "APPROVED"
            );

            memberRepo.save(member);

            return "Joined Group Successfully";

        }

        else{

            member.setStatus(
                    "PENDING"
            );

            memberRepo.save(member);

            return "Join Request Sent";

        }

    }

    // =========================
    // APPROVE REQUEST
    // =========================

    public String approveRequest(
            Long id){

        GroupMember member =
                memberRepo.findById(id)
                .orElse(null);

        if(member == null){

            return "Request Not Found";

        }

        member.setStatus(
                "APPROVED"
        );

        memberRepo.save(member);

        return "Request Approved";

    }

    // =========================
    // REJECT REQUEST
    // =========================

    public String rejectRequest(
            Long id){

        GroupMember member =
                memberRepo.findById(id)
                .orElse(null);

        if(member == null){

            return "Request Not Found";

        }

        member.setStatus(
                "REJECTED"
        );

        memberRepo.save(member);

        return "Request Rejected";

    }

    // =========================
    // GET PENDING REQUESTS
    // =========================

    public List<GroupMember>
    getPendingRequests(
            String ngoEmail){

        return memberRepo
                .findByNgoEmailAndStatus(

                        ngoEmail,

                        "PENDING"

                );

    }

    // =========================
    // LEAVE GROUP
    // =========================

    @Transactional
    public String leaveGroup(

            Long groupId,

            String userEmail

    ){

        GroupMember existing =
                memberRepo
                        .findByGroupIdAndUserEmail(

                                groupId,

                                userEmail

                        );

        if(existing == null){

            return "Group Membership Not Found";

        }

        memberRepo.delete(existing);

        return "Left Group Successfully";

    }

    // =========================
    // GET GROUP MEMBERS
    // =========================

    public List<GroupMember>
    getGroupMembers(
            Long groupId){

        return memberRepo
                .findByGroupIdAndStatus(

                        groupId,

                        "APPROVED"

                );

    }

    // =========================
    // GET USER JOINED GROUPS
    // =========================

    public List<GroupMember>
    getUserGroups(
            String userEmail){

        return memberRepo
                .findByUserEmail(
                        userEmail
                );

    }

}
