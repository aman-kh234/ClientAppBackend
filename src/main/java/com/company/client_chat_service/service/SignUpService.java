package com.company.client_chat_service.service;

import com.company.client_chat_service.dto.requestDto.UserRequestDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface SignUpService {
    public String userRegistration(@RequestBody UserRequestDto userRequestDto);
}
