package com.example.coupon.repository;

import com.example.coupon.entity.ConsumptionHistory;
import com.example.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsumptionHistoryRepository extends JpaRepository<ConsumptionHistory, Long> {
    List<ConsumptionHistory> findByCoupon_Code(String code);
    ConsumptionHistory findByOrderCodeAndCoupon_Code(String orderCode, String couponCode);
}
