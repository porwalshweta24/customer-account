package com.core.customeraccount.exception;

public class ValueNotValidException extends RuntimeException {
    public ValueNotValidException() {
        super("The value is not valid");
    }
}