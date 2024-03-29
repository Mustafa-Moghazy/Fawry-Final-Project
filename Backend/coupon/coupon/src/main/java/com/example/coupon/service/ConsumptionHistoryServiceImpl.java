package com.example.coupon.service;

import com.example.coupon.dto.consumeCouponDTO;
import com.example.coupon.entity.ConsumptionHistory;
import com.example.coupon.entity.Coupon;
import com.example.coupon.exception.ConsumeException;
import com.example.coupon.repository.ConsumptionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ConsumptionHistoryServiceImpl implements ConsumptionHistoryService{
    @Autowired
    private ConsumptionHistoryRepository chRepo;

    @Override
    public void save(ConsumptionHistory consumptionHistory) {
        chRepo.save(consumptionHistory);
    }

    @Override
    public List<ConsumptionHistory> findAll() {
        return chRepo.findAll();
    }

    @Override
    public List<ConsumptionHistory> getCouponConsumptions(String code) {
        return chRepo.findByCoupon_Code(code);
    }

    @Override
    public void deleteCouponConsumptionHistory(String code) {
        List<ConsumptionHistory> consumptionHistoryList = getCouponConsumptions(code);
        chRepo.deleteAll(consumptionHistoryList);
    }
    @Override
    public ConsumptionHistory findByOrderCodeAndCoupon_Code(String orderCode, String couponCode) {
        return chRepo.findByOrderCodeAndCoupon_Code(orderCode, couponCode);
    }

    @Override
    public void delete(ConsumptionHistory consumptionHistory) {
        chRepo.delete(consumptionHistory);
    }

}
