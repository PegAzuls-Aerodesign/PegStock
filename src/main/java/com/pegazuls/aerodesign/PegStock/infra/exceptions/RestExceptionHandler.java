package com.pegazuls.aerodesign.PegStock.infra.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException e) {
        return ResponseEntity.badRequest().body(new DTOValidationException(e.getMessage()));
    }

    private record DTOValidationException(String type, String message) {
        public DTOValidationException(String message) {
            this("Validation", message);
        }
    }
}
