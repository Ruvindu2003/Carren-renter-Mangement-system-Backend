package org.example.service;

import org.example.dto.SingupRequwest;
import org.example.entity.UserEntity;


public interface AuthService {
    UserEntity createCustomer(SingupRequwest singupRequwest);
    boolean hasCustomeremails(String email);
}
