package com.bcp.services.customer.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class ApiException extends RuntimeException {
    private final String componentName;
    private final String code;
    private final HttpStatus httpStatus;

    public ApiException(String message, String componentName, String code, HttpStatus httpStatus) {
        super(message);
        this.componentName = componentName;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public ApiException(String message, Throwable cause, String componentName, String code, HttpStatus httpStatus) {
        super(message, cause);
        this.componentName = componentName;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public ApiException(Throwable cause, String componentName, String code, HttpStatus httpStatus) {
        super(cause);
        this.componentName = componentName;
        this.code = code;
        this.httpStatus = httpStatus;
    }
}