package com.example.product.exception;

public class ProductNotFoundEception extends RuntimeException {
    public ProductNotFoundEception(String message) {
        super(message);
    }
}
