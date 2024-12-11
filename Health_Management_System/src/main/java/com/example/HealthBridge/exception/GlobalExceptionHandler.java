package com.example.HealthBridge.exception;

import com.example.HealthBridge.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for user-related exceptions.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles generic exceptions and returns a response entity with a bad request status.
     *
     * @param exc the exception to handle
     * @return a response entity containing the user exception DTO and bad request status
     */
    @ExceptionHandler
    public ResponseEntity<ExceptionDto> handleException(Exception exc) {
        ExceptionDto error = new ExceptionDto();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<ExceptionDto> handleException(StateNotFoundException exc) {
        ExceptionDto error = new ExceptionDto();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
