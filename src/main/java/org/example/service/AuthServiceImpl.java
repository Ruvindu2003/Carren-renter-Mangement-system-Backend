package org.example.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.RequiredArgsConstructor;
import org.example.dto.SingupRequwest;
import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.example.enums.UserRoles;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements  AuthService{
    final UserRepository userRepository;
    final ModelMapper modelMapper;



    @Override
    public UserEntity createCustomer(SingupRequwest signupRequest) {
        System.out.println("Creating user: " + signupRequest);


        UserEntity user = modelMapper.map(signupRequest, UserEntity.class);


        user.setUserRoles(UserRoles.CUSTOMER);


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
    public boolean hasCustomeremails(String email) {
        return userRepository.findByEmail(email).isPresent();

    }
}
