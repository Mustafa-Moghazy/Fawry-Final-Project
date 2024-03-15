package com.example.coupon.exception;

public class FindByCodeException extends RuntimeException {
    public FindByCodeException(String message){
        super(message);
    }
    public FindByCodeException(String message, Throwable cause){
        super(message, cause);
    }
}
