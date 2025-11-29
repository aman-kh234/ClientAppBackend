package com.company.client_chat_service.exception;

public abstract class GlobalException extends RuntimeException {
    private final String code; // optional app-specific error code

    protected GlobalException(String message) {
        super(message);
        this.code = null;
    }

    protected GlobalException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
