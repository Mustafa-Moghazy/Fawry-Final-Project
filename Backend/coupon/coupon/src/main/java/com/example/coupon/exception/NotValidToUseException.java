package com.example.coupon.exception;

public class NotValidToUseException extends RuntimeException {
    public NotValidToUseException(String message) {
        super(message);
    }
}
