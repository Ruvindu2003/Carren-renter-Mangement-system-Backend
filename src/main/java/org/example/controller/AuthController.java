package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.SingupRequwest;
import org.example.entity.UserEntity;
import org.example.service.AuthService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/auth")


public class AuthController {
    final AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity<?> createCustomer(@RequestBody SingupRequwest signupRequest) {
        System.out.println("Received signup request: " + signupRequest);

        if (authService.hasCustomeremails(signupRequest.getEmail())) {
            System.out.println("Email already exists: " + signupRequest.getEmail());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Email already exists. Please use a different one.");
        }

        try {
            UserEntity userEntity = authService.createCustomer(signupRequest);
            System.out.println("User created successfully: " + userEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(userEntity);
        } catch (Exception e) {
            System.out.println("Error creating user: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating user: " + e.getMessage());
        }
    }
    }







