package com.example.product.exception;

public class CreateCategoryException extends RuntimeException{
    public CreateCategoryException(String message) {
        super(message);
    }
    public CreateCategoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
