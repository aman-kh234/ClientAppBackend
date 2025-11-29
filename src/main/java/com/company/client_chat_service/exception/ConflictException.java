package com.company.client_chat_service.exception;

public class ConflictException extends GlobalException{
    public ConflictException(String message) {
        super(message);
    }
    public ConflictException(String message, String code) {
        super(message, code);
    }
}
