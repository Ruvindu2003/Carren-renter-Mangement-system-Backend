package org.example.service;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.RequiredArgsConstructor;
import org.example.dto.SingupRequwest;
import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.example.enums.UserRoles;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements  AuthService{
    final UserRepository userRepository;
    final ModelMapper modelMapper;



    @PostConstruct
    public  void  createAdminaccount(){
        Optional<UserEntity> adminAccount = userRepository.findByRoles(UserRoles.ADMIN);
        if (adminAccount.isEmpty()) {

            UserEntity newAdminAccount = new UserEntity();
            newAdminAccount.setName("ADMIN");
            newAdminAccount.setRoles(UserRoles.ADMIN);
            newAdminAccount.setEmail("ruvindusharadaha22@gmail.com");
            newAdminAccount.setPassword(new BCryptPasswordEncoder().encode("1234567"));
            userRepository.save(newAdminAccount);
            System.out.println("Admin account created successfully.");
        } else {
            System.out.println("Admin account already exists.");
        }
    }




    @Override
    public UserEntity createCustomer(SingupRequwest signupRequest) {
        System.out.println("Creating user: " + signupRequest);


        UserEntity user = modelMapper.map(signupRequest, UserEntity.class);


        user.setRoles(UserRoles.CUSTOMER);


        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(encodedPassword);

        try {
            // Save the user to the database
            UserEntity savedUser = userRepository.save(user);
            System.out.println("User saved: " + savedUser);
            return savedUser;
        } catch (Exception e) {
            System.out.println("Error saving user: " + e.getMessage());
            throw new RuntimeException("Error saving user: " + e.getMessage());
        }
    }

    @Override
    public boolean hasCustomeremails(String name) {
        UserEntity user = userRepository.findByName(name);

        // Check if the user exists and has emails
        return user != null && user.getName() != null && !user.getName().isEmpty();
    }
    }


//    @Override
//    public boolean hasCustomeremails(String email) {
//        return userRepository.findByEmail(email).isPresent();
//
//    }

