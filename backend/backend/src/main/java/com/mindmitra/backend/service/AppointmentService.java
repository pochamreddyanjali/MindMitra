package com.mindmitra.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindmitra.backend.entity.Appointment;
import com.mindmitra.backend.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repo;

    // =========================
    // SAVE APPOINTMENT
    // =========================

    public String saveAppointment(
            Appointment appointment) {

        // DEFAULT STATUS

        appointment.setStatus("PENDING");

        repo.save(appointment);

        return "Appointment Request Sent Successfully";

    }

    // =========================
    // GET SPECIALIST APPOINTMENTS
    // =========================

    public List<Appointment> getAppointmentsBySpecialist(
            String specialistEmail) {

        return repo.findBySpecialistEmail(
                specialistEmail);

    }

    // =========================
    // GET USER APPOINTMENTS
    // =========================

    public List<Appointment> getAppointmentsByUser(
            String userEmail) {

        return repo.findByUserEmail(
                userEmail);

    }

    // =========================
    // GET PENDING APPOINTMENTS
    // =========================

    public List<Appointment> getPendingAppointments(
            String specialistEmail) {

        return repo.findBySpecialistEmailAndStatus(

                specialistEmail,

                "PENDING"

        );

    }

    // =========================
    // GET ACCEPTED APPOINTMENTS
    // =========================

    public List<Appointment> getAcceptedAppointments(

            String specialistEmail

    ){

        return repo.findBySpecialistEmailAndStatus(

                specialistEmail,

                "ACCEPTED"

        );

    }

    // =========================
    // ACCEPT APPOINTMENT
    // =========================

    public String acceptAppointment(

            Long id,

            String specialistOpinion,

            String specialistAvailability,

            String communicationMode,

            String meetingLink

    ) {

        Appointment appointment =

                repo.findById(id)
                        .orElse(null);

        if (appointment == null) {

            return "Appointment Not Found";

        }

        // STATUS

        appointment.setStatus(
                "ACCEPTED");

        // SPECIALIST RESPONSE

        appointment.setSpecialistOpinion(
                specialistOpinion);

        appointment.setSpecialistAvailability(
                specialistAvailability);

        appointment.setCommunicationMode(
                communicationMode);

        appointment.setMeetingLink(
                meetingLink);

        repo.save(appointment);

        return "Appointment Accepted Successfully";

    }

    // =========================
    // REJECT APPOINTMENT
    // =========================

    public String rejectAppointment(

            Long id,

            String specialistOpinion

    ) {

        Appointment appointment =

                repo.findById(id)
                        .orElse(null);

        if (appointment == null) {

            return "Appointment Not Found";

        }

        appointment.setStatus(
                "REJECTED");

        appointment.setSpecialistOpinion(
                specialistOpinion);

        repo.save(appointment);

        return "Appointment Rejected Successfully";

    }

}