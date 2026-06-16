package com.mindmitra.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // =========================
    // PASSWORD ENCODER
    // =========================

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

    // =========================
    // SECURITY FILTER CHAIN
    // =========================

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http

            // DISABLE CSRF

            .csrf(csrf -> csrf.disable())

            // AUTHORIZE REQUESTS

            .authorizeHttpRequests(auth -> auth

                .requestMatchers(

                    // AUTH

                    "/auth/**",

                    // JOURNAL

                    "/journal/**",

                    // TODO

                    "/todo/**",

                    // GAMES

                    "/game/**",

                    // ADMIN

                    "/admin/**",

                    // SPECIALIST

                    "/specialist/**",

                    // NGO

                    "/ngo/**",

                    // APPOINTMENTS

                    "/appointment/**",

                    // NORMAL CHAT

                    "/message/**",

                    // NGO GROUPS

                    "/ngo-group/**",

                    // GROUP MEMBERS

                    "/group-member/**",

                    // ANNOUNCEMENTS

                    "/announcement/**",

                    // POLLS

                    "/poll/**",

                    // POLL VOTES

                    "/poll-vote/**",

                    // NGO CHAT

                    "/ngo-chat/**",

                    // NGO EVENTS

                    "/ngo-event/**",
                    "/ngo-follower/**",
                    "/ngo-group/**",
                    "/ai/**"

                )

                .permitAll()

                // OTHER REQUESTS

                .anyRequest()

                .authenticated()

            );

        return http.build();

    }

}