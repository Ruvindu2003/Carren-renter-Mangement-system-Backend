package org.example.service.jwt;

import lombok.RequiredArgsConstructor;
import org.example.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserServiceimpl implements  UserService {
    private final UserRepository userRepository;


    @Override
    public UserDetailsService userDetailsService() {
        return username -> {

            UserDetails userDetails = userRepository.findByName(username);
            if (userDetails == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return userDetails;
        };
    }
}
