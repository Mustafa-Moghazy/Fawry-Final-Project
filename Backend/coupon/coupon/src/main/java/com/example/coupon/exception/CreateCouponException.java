package com.example.coupon.exception;

public class CreateCouponException extends RuntimeException {
    public CreateCouponException(String message) {
        super(message);
    }
    public CreateCouponException(String message, Throwable cause){
        super(message, cause);
    }
}
