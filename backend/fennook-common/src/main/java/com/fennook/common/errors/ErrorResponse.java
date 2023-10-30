package com.fennook.common.errors;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {
    private final int code;
    private final String status;
    private final String message;
    private Date timestamp;
    private Object data;

    public ErrorResponse(HttpStatus status, String message) {
        this.code = status.value();
        this.status = status.name();
        this.message = message;
        this.timestamp = new Date();
    }

    public ErrorResponse(HttpStatus status, String message, Object data) {
        this.code = status.value();
        this.status = status.name();
        this.message = message;
        this.timestamp = new Date();
        this.data = data;
    }
}