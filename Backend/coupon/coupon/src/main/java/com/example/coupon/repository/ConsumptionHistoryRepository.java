package com.example.coupon.repository;

import com.example.coupon.dto.ConsumptionHistoryDTO;
import com.example.coupon.entity.ConsumptionHistory;
import com.example.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsumptionHistoryRepository extends JpaRepository<ConsumptionHistory, Long> {
    List<ConsumptionHistory> findByCoupon(Coupon coupon);
    ConsumptionHistory findByOrderCodeAndCoupon_Code(String orderCode, String couponCode);
}
