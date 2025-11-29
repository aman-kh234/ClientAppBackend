package com.company.client_chat_service.service.impl;

import com.company.client_chat_service.dto.requestDto.UserRequestDto;
import com.company.client_chat_service.entity.Role;
import com.company.client_chat_service.entity.User;
import com.company.client_chat_service.exception.BadRequestException;
import com.company.client_chat_service.exception.ConflictException;
import com.company.client_chat_service.mapper.mapUserToUserRequestDto;
import com.company.client_chat_service.repository.RoleRepository;
import com.company.client_chat_service.repository.UserRepository;
import com.company.client_chat_service.service.SignUpService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private mapUserToUserRequestDto userMapper;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional // ensure transactional boundary
    public String userRegistration(UserRequestDto dto) {
        // Basic validation
        if (dto.getUsername() == null || dto.getUsername().isBlank()) {
            throw new BadRequestException("username is required");
        }
        if (dto.getPassword() == null || dto.getPassword().isBlank()) {
            throw new BadRequestException("password is required");
        }
        // check dupes
        if (userRepository.existsByUserName(dto.getUsername())) {
            throw new ConflictException("username already exists");
        }
        if (dto.getEmail() != null && userRepository.existsByEmail(dto.getEmail())) {
            throw new ConflictException("email already exists");
        }

        String roleName = dto.getRole() != null && !dto.getRole().isBlank()
                ? dto.getRole().trim().toUpperCase()
                : "ROLE_USER";

        Role role = roleRepository.findByName(roleName).orElse(null);

        if (role == null) {
            role = new Role();
            role.setName(roleName);
            role = roleRepository.save(role); // now managed
        }

        User user = userMapper.mapUserRequestDto(dto, role);

         user.setPasswordHash(passwordEncoder.encode(dto.getPassword()));

        userRepository.save(user); // role is managed, so no TransientPropertyValueException

        return "User registered successfully";
    }
}
