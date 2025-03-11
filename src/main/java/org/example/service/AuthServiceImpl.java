package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.SingupRequwest;
import org.example.dto.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements  AuthService{

    @Override
    public User createCustomer(SingupRequwest singupRequwest) {
        return null;
    }
}
