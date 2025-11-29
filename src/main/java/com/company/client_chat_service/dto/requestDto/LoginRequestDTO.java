package com.company.client_chat_service.dto.requestDto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LoginRequestDTO {
    private String username;
    private String password;
}