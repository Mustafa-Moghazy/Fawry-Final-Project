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
    @Autowired
    private CouponService couponService;

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
    public void cancelCouponConsumption(consumeCouponDTO chDTO) {
        ConsumptionHistory consumptionHistory = chRepo.findByOrderCodeAndCoupon_Code(chDTO.getOrderCode(), chDTO.getCouponCode());
        couponService.decrementNumberOfUsages(consumptionHistory.getCoupon());
        chRepo.delete(consumptionHistory);
    }
}
