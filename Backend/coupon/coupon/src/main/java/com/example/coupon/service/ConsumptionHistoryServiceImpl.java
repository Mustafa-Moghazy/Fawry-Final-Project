package com.example.coupon.service;

import com.example.coupon.dto.ConsumptionHistoryDTO;
import com.example.coupon.dto.CouponDTO;
import com.example.coupon.entity.ConsumptionHistory;
import com.example.coupon.entity.Coupon;
import com.example.coupon.exception.NotValidToUseException;
import com.example.coupon.repository.ConsumptionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ConsumptionHistoryServiceImpl implements ConsumptionHistoryService{
    @Autowired
    ConsumptionHistoryRepository chRepo;
    @Autowired
    CouponService couponService;
    @Override
    public Coupon consume(ConsumptionHistoryDTO chDTO) {
        Coupon theCoupon = couponService.findByCode(chDTO.getCouponCode());
        if(ISCouponValidToUse(theCoupon)){
            theCoupon.setCurrentNumberOfUsages(theCoupon.getCurrentNumberOfUsages() + 1);
            ConsumptionHistory consumptionHistory = new ConsumptionHistory(chDTO.getOrderId(), theCoupon, new Date());
            chRepo.save(consumptionHistory);
            return theCoupon;
        }else {
            throw new NotValidToUseException("Coupon With Code: " + chDTO.getCouponCode() + "Not Valid To Use");
        }

    }
    public boolean ISCouponValidToUse(Coupon coupon){
        return coupon.getMaxNumberOfUsages() > coupon.getCurrentNumberOfUsages() &&
                coupon.getExpiryDate().after(new Date());
    }
    @Override
    public List<ConsumptionHistory> findAll() {
        return chRepo.findAll();
    }
}
