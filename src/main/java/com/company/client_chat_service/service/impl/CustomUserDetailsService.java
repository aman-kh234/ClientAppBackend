package com.company.client_chat_service.service.impl;

import com.company.client_chat_service.entity.User;
import com.company.client_chat_service.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository repo) {
        this.userRepository = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // Assume User has getRole().getName() or getRoles(). Adjust as needed.
        var authorities = List.of(new SimpleGrantedAuthority(u.getRole().getName()));

        return new org.springframework.security.core.userdetails.User(
                u.getUsername(), // username field
                u.getPasswordHash(), // hashed password
                true, true, true, true,
                authorities
        );
    }
}
