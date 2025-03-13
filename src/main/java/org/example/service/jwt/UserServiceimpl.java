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
        return  new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

                return userRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User Not found"));
            }
        };
    }
}
