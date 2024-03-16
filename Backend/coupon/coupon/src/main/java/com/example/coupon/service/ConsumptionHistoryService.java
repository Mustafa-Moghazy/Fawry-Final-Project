package com.example.coupon.service;

import com.example.coupon.dto.ConsumptionHistoryDTO;

public interface ConsumptionHistoryService {
    boolean consume(ConsumptionHistoryDTO chDTO);
}
