package com.mindmitra.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindmitra.backend.entity.GroupMember;

@Repository
public interface GroupMemberRepository
        extends JpaRepository<GroupMember, Long> {

    // =========================
    // GET MEMBERS BY GROUP ID
    // =========================

    List<GroupMember>
    findByGroupId(
            Long groupId
    );

    // =========================
    // GET APPROVED MEMBERS
    // =========================

    List<GroupMember>
    findByGroupIdAndStatus(
            Long groupId,
            String status
    );

    // =========================
    // GET GROUPS JOINED BY USER
    // =========================

    List<GroupMember>
    findByUserEmail(
            String userEmail
    );

    // =========================
    // GET USER GROUPS BY STATUS
    // =========================

    List<GroupMember>
    findByUserEmailAndStatus(
            String userEmail,
            String status
    );

    // =========================
    // CHECK USER ALREADY JOINED
    // =========================

    GroupMember
    findByGroupIdAndUserEmail(

            Long groupId,

            String userEmail

    );

    // =========================
    // GET PENDING REQUESTS
    // =========================

    List<GroupMember>
    findByNgoEmailAndStatus(

            String ngoEmail,

            String status

    );

    // =========================
    // REMOVE USER FROM GROUP
    // =========================

    void deleteByGroupIdAndUserEmail(

            Long groupId,

            String userEmail

    );

}