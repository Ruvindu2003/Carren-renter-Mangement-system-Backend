package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.SingupRequwest;
import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.example.util.UserRoles;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements  AuthService{
    final UserRepository userRepository;
    final ModelMapper modelMapper;


    @Override
    public UserEntity createCustomer(SingupRequwest singupRequwest) {
        System.out.println("Creating user: " + singupRequwest);
        UserEntity user = modelMapper.map(singupRequwest, UserEntity.class);
        user.setUserRoles(UserRoles.CUSTOMER);

        try {
            UserEntity savedUser = userRepository.save(user);
            System.out.println("User saved: " + savedUser); // Log saved user
            return savedUser;
        } catch (Exception e) {
            System.out.println("Error saving user: " + e.getMessage()); // Log save error
            throw new RuntimeException("Error saving user: " + e.getMessage());
        }
    }


    @Override
    public boolean hasCustomeremails(String email) {
        return userRepository.findByEmail(email).isPresent();

    }
}
