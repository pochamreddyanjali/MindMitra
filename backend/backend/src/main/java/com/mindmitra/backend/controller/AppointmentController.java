package com.mindmitra.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mindmitra.backend.entity.Appointment;
import com.mindmitra.backend.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    // =========================
    // SAVE APPOINTMENT
    // =========================

    @PostMapping("/save")
    public String saveAppointment(
            @RequestBody Appointment appointment) {

        return service.saveAppointment(
                appointment);

    }

    // =========================
    // GET APPOINTMENTS OF SPECIALIST
    // =========================

    @GetMapping("/specialist/{email}")
    public List<Appointment> getAppointmentsBySpecialist(

            @PathVariable String email

    ) {

        return service
                .getAppointmentsBySpecialist(
                        email);

    }

    // =========================
    // GET PENDING APPOINTMENTS
    // =========================

    @GetMapping("/pending/{email}")
    public List<Appointment> getPendingAppointments(

            @PathVariable String email

    ) {

        return service.getPendingAppointments(
                email);

    }

    // =========================
    // GET ACCEPTED APPOINTMENTS
    // =========================

    @GetMapping("/accepted/{email}")
    public List<Appointment> getAcceptedAppointments(

            @PathVariable String email

    ){

        return service.getAcceptedAppointments(
                email
        );

    }

    // =========================
    // GET APPOINTMENTS OF USER
    // =========================

    @GetMapping("/user/{email}")
    public List<Appointment> getAppointmentsByUser(

            @PathVariable String email

    ) {

        return service
                .getAppointmentsByUser(
                        email);

    }

    // =========================
    // ACCEPT APPOINTMENT
    // =========================

    @PutMapping("/accept/{id}")
    public String acceptAppointment(

            @PathVariable Long id,

            @RequestBody Map<String, String> body

    ) {

        return service.acceptAppointment(

                id,

                body.get(
                        "specialistOpinion"),

                body.get(
                        "specialistAvailability"),

                body.get(
                        "communicationMode"),

                body.get(
                        "meetingLink")

        );

    }

    // =========================
    // REJECT APPOINTMENT
    // =========================

    @PutMapping("/reject/{id}")
    public String rejectAppointment(

            @PathVariable Long id,

            @RequestBody Map<String, String> body

    ) {

        return service.rejectAppointment(

                id,

                body.get(
                        "specialistOpinion")

        );

    }

}