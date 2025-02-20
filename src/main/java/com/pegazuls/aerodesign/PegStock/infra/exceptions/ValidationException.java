package com.pegazuls.aerodesign.PegStock.infra.exceptions;

public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
