package com.mindmitra.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder =
	            new BCryptPasswordEncoder();

	        SpringApplication.run(
	            BackendApplication.class,
	            args
	        );
	}

}
