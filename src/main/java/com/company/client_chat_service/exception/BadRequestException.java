package com.company.client_chat_service.exception;


public class BadRequestException extends GlobalException {
    public BadRequestException(String message) {
        super(message);
    }
    public BadRequestException(String message, String code) {
        super(message, code);
    }
}
