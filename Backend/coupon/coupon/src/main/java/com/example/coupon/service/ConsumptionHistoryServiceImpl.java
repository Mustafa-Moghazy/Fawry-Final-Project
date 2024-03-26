package com.example.coupon.service;

import com.example.coupon.dto.ConsumptionHistoryDTO;
import com.example.coupon.entity.ConsumptionHistory;
import com.example.coupon.entity.Coupon;
import com.example.coupon.exception.NotValidToUseException;
import com.example.coupon.repository.ConsumptionHistoryRepository;
import com.example.coupon.repository.CouponRepository;
import org.antlr.v4.runtime.misc.LogManager;
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
    public Coupon consume(ConsumptionHistoryDTO chDTO) {
        Coupon theCoupon = couponService.findByCode(chDTO.getCouponCode());
        if(isCouponValidToUse(theCoupon)){
            theCoupon.setCurrentNumberOfUsages(theCoupon.getCurrentNumberOfUsages() + 1);
            ConsumptionHistory consumptionHistory = new ConsumptionHistory(chDTO.getOrderCode(), theCoupon, new Date());
            chRepo.save(consumptionHistory);
            return theCoupon;
        }else {
            throw new NotValidToUseException("Coupon With Code: " + chDTO.getCouponCode() + "Not Valid To Use");
        }
    }
    public boolean isCouponValidToUse(Coupon coupon){
        return coupon.getMaxNumberOfUsages() > coupon.getCurrentNumberOfUsages() &&
                coupon.getExpiryDate().after(new Date());
    }
    @Override
    public List<ConsumptionHistory> findAll() {
        return chRepo.findAll();
    }

    @Override
    public List<ConsumptionHistory> getCouponConsumption(String code) {
        Coupon theCoupon = couponService.findByCode(code);
        return chRepo.findByCoupon(theCoupon);
    }

    @Override
    public void cancelCouponConsumption(ConsumptionHistoryDTO chDTO) {
        ConsumptionHistory consumptionHistory = chRepo.findByOrderCodeAndCoupon_Code(chDTO.getOrderCode(), chDTO.getCouponCode());
        chRepo.delete(consumptionHistory);
        couponService.decrementNumberOfUsages(chDTO.getCouponCode());
    }
}
