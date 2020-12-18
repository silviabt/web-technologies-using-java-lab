package com.unibuc.lab11.exception;

public class AnotherEntityNotFoundException extends Exception {

    public AnotherEntityNotFoundException(String entity) {
        super(String.format("Entity: %s was not found", entity));
    }
}
