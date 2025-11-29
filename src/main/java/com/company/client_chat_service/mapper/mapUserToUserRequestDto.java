package com.company.client_chat_service.mapper;

import com.company.client_chat_service.dto.requestDto.UserRequestDto;
import com.company.client_chat_service.entity.Role;
import com.company.client_chat_service.entity.User;
import org.springframework.stereotype.Component;


@Component
public class mapUserToUserRequestDto {
    public User mapUserRequestDto(UserRequestDto userRequestDto,Role role) {
        return User.builder()
                .role(role)
                .email(userRequestDto.getEmail())
                .username(userRequestDto.getUsername())
                .passwordHash(userRequestDto.getPassword())
                .phone(userRequestDto.getPhone())
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .build();
    }

    public Role mapRoleRequestDto(UserRequestDto role) {
        return Role.builder()
                .name(role.getRole())
                .build();
    }
}
