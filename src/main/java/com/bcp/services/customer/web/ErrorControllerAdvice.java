package com.bcp.services.customer.web;

import com.bcp.services.customer.util.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Error Controller Advice.
 * This class is used to handle the exceptions.
 */
@RestControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleApiException(ApiException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getComponentName(), ex.getCode());
        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
    }

    @AllArgsConstructor
    public static class ErrorResponse {
        private String message;
        private String componentName;
        private String code;
    }
}
