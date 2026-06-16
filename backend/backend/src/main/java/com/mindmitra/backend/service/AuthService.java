package com.mindmitra.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mindmitra.backend.entity.User;
import java.util.Optional;
import com.mindmitra.backend.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    public String register(User user) {

        Optional<User> existingUser = repo.findByEmail(user.getEmail());

        if(existingUser.isPresent()) {
            return "Email already exists";
        }

        user.setPassword(encoder.encode(user.getPassword()));

        repo.save(user);

        return "Registration successful";
    }

    public User login(String email, String password) {

        User user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (encoder.matches(password, user.getPassword())) {

            return user;

        }

        throw new RuntimeException("Invalid Password");
    }
}