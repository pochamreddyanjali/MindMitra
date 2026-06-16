package com.mindmitra.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mindmitra.backend.entity.User;
import com.mindmitra.backend.service.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public String register(@RequestBody User user) {

        return service.register(user);

    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {

        return service.login(user.getEmail(), user.getPassword());

    }
}