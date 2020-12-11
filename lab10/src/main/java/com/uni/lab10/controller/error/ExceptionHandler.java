package com.uni.lab10.controller.error;

import com.uni.lab10.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<String> handleArgumentNotValidException(MethodArgumentNotValidException exception) {
        FieldError fieldError = exception.getFieldError();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(String.format("Field: %s has invalid value: %s with message: %s",
                        null != fieldError ? fieldError.getField() : "unknown",
                        null != fieldError ? fieldError.getRejectedValue() : "unknown",
                        null != fieldError ? fieldError.getDefaultMessage() : "unknown"));
    }
}
