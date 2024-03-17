package com.example.coupon.service;

import com.example.coupon.dto.ConsumptionHistoryDTO;
import com.example.coupon.entity.ConsumptionHistory;
import com.example.coupon.entity.Coupon;

import java.util.List;

public interface ConsumptionHistoryService {
    Coupon consume(ConsumptionHistoryDTO chDTO);
    List<ConsumptionHistory> findAll();
}
