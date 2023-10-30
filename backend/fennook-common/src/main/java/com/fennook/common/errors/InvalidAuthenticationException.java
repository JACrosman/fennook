package com.fennook.common.errors;

public class InvalidAuthenticationException extends RuntimeException {
    public InvalidAuthenticationException() {
        super("Invalid e-mail or password.");
    }

    public InvalidAuthenticationException(String message) {
        super(message);
    }
}
