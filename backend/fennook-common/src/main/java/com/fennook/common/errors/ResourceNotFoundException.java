package com.fennook.common.errors;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Could not find resource.");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
