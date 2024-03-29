package com.example.coupon.exception;

public class CouponNotFoundException extends RuntimeException {
    public CouponNotFoundException(String message){
        super(message);
    }
    public CouponNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
