package org.example.service;

import org.example.dto.SingupRequwest;
import org.example.dto.User;

public interface AuthService {
    User createCustomer(SingupRequwest singupRequwest);
}
