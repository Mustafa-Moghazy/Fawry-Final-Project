package com.example.coupon.dto;

import lombok.Data;

@Data
public class ConsumptionHistoryDTO {
    private long orderId;
    private String couponCode;
}
