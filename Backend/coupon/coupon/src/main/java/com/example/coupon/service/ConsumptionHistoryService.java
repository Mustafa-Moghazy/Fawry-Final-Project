package com.example.coupon.service;

import com.example.coupon.dto.consumeCouponDTO;
import com.example.coupon.entity.ConsumptionHistory;

import java.util.List;

public interface ConsumptionHistoryService {
    void save(ConsumptionHistory consumptionHistory);
    List<ConsumptionHistory> findAll();
    List<ConsumptionHistory> getCouponConsumptions(String CouponCode);
    void cancelCouponConsumption(consumeCouponDTO consumeCouponDTO);
}
