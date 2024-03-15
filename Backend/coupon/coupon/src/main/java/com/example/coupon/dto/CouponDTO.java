package com.example.coupon.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CouponDTO {
    private String code;
    private String valueType;
    private double value;
    private long maxNumberOfUsages;
    private Date expiryDate;
}
