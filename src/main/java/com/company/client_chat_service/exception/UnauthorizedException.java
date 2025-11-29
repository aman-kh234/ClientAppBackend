package com.company.client_chat_service.exception;

// package com.example.auth.exception;

public class UnauthorizedException extends GlobalException {
    public UnauthorizedException(String message) {
        super(message);
    }
    public UnauthorizedException(String message, String code) {
        super(message, code);
    }
}
