package com.example.coupon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CreateCouponException.class)
    public ResponseEntity<Object> handleCreateCouponException(CreateCouponException ex, WebRequest request){
        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(CouponNotFoundException.class)
    public ResponseEntity<Object> handleCouponNotFoundException(CouponNotFoundException ex, WebRequest request){
        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConsumeException.class)
    public ResponseEntity<Object> handleNotValidToUseException(ConsumeException ex, WebRequest request){
        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConsumedWithSameOrderException.class)
    public ResponseEntity<Object> handleConsumedWithSameOrderException(ConsumedWithSameOrderException ex, WebRequest request){
        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConsumptionHistoryException.class)
    public ResponseEntity<Object> handleConsumptionHistoryException(ConsumptionHistoryException ex, WebRequest request){
        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
