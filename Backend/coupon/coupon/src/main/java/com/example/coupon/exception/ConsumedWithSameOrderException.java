package com.example.coupon.exception;

public class ConsumedWithSameOrderException extends RuntimeException {
    public ConsumedWithSameOrderException(String message) {
        super(message);
    }
}
