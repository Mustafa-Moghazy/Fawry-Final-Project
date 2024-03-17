package com.example.coupon.repository;

import com.example.coupon.entity.ConsumptionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumptionHistoryRepository extends JpaRepository<ConsumptionHistory, Long> {

}
