package com.example.coupon.service;

import com.example.coupon.dto.consumeCouponDTO;
import com.example.coupon.dto.CouponDTO;
import com.example.coupon.entity.ConsumptionHistory;
import com.example.coupon.entity.Coupon;
import com.example.coupon.exception.ConsumeException;
import com.example.coupon.exception.CreateCouponException;
import com.example.coupon.exception.CouponNotFoundException;
import com.example.coupon.repository.CouponRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CouponServiceImpl implements CouponService{
    @Autowired
    private CouponRepository couponRepo;
    @Autowired
    private ConsumptionHistoryService chService;

    @Override
    public List<Coupon> findAll() {
        return couponRepo.findAll();
    }

    @Override
    public Coupon findByCode(String code) {
        Coupon theCoupon = couponRepo.findByCode(code);
        if (theCoupon == null)
            throw new CouponNotFoundException("Coupon with code: " + code + "Not Found!!!");
        return theCoupon;
    }

    @Override
    public Coupon createCoupon(CouponDTO couponDTO) {
        Coupon theCoupon = couponRepo.findByCode(couponDTO.getCode());
        if (theCoupon != null){
            throw new CreateCouponException("Coupon With Code: " + couponDTO.getCode() + " Already Exist");
        }
        if(validToSave(couponDTO)){
            Coupon newCoupon = new Coupon(couponDTO.getCode(), couponDTO.getExpiryDate(), couponDTO.getValueType(), couponDTO.getValue(), couponDTO.getMaxNumberOfUsages());
            return couponRepo.save(newCoupon);
        }else {
            throw new CreateCouponException("Not Valid Data Provided");
        }
    }

    @Override
    public Coupon updateCoupon(CouponDTO couponDTO) {
        Coupon theCoupon = couponRepo.findByCode(couponDTO.getCode());
        if(theCoupon == null){
            throw new CouponNotFoundException("Coupon with code: " + couponDTO.getCode() + " Not found to update it!!");
        }
        if (validToSave(couponDTO)) {
            // set new values //
            theCoupon.setCode(couponDTO.getCode());
            theCoupon.setValue(couponDTO.getValue());
            theCoupon.setValueType(couponDTO.getValueType());
            theCoupon.setMaxNumberOfUsages(couponDTO.getMaxNumberOfUsages());
            theCoupon.setExpiryDate(couponDTO.getExpiryDate());
            // save new object value //
            return couponRepo.save(theCoupon);
        }else {
            throw new CreateCouponException("Not Valid Data Provided");
        }
    }

    @Transactional
    @Override
    public void deleteCoupon(String code) {
        Coupon theCoupon = couponRepo.findByCode(code);
        if(theCoupon == null){
            throw new CouponNotFoundException("Coupon with code: " + code + " Not found to delete it!!");
        }
        couponRepo.deleteByCode(code);
    }

    @Override
    public boolean validToSave(CouponDTO coupon){
        return coupon != null &&
                coupon.getCode() != null &&
                !coupon.getCode().isEmpty() &&
                coupon.getMaxNumberOfUsages() > 0 &&
                coupon.getValue() > 0 &&
                (coupon.getValueType().equalsIgnoreCase("FIXED") ||
                        coupon.getValueType().equalsIgnoreCase("PERCENTAGE")) &&
                coupon.getExpiryDate().after(new Date());
    }

    @Override
    public Coupon consume(consumeCouponDTO consumeCouponDTO) {
        Coupon theCoupon = findByCode(consumeCouponDTO.getCouponCode());
        if(validToConsume(theCoupon)){
            incrementNumberOfUsages(theCoupon);
            ConsumptionHistory consumptionHistory = new ConsumptionHistory(consumeCouponDTO.getOrderCode(), theCoupon, new Date());
            chService.save(consumptionHistory);
            return theCoupon;
        }else {
            throw new ConsumeException("Coupon With Code: " + consumeCouponDTO.getCouponCode() + " Not Valid To Consume");
        }
    }

    @Override
    public boolean validToConsume(Coupon coupon) {
        return coupon.getMaxNumberOfUsages() > coupon.getCurrentNumberOfUsages() &&
                coupon.getExpiryDate().after(new Date());
    }

    @Override
    public void decrementNumberOfUsages(Coupon coupon) {
        coupon.setCurrentNumberOfUsages(coupon.getCurrentNumberOfUsages() - 1);
        couponRepo.save(coupon);
    }

    @Override
    public void incrementNumberOfUsages(Coupon coupon) {
        coupon.setCurrentNumberOfUsages(coupon.getCurrentNumberOfUsages() + 1);
        couponRepo.save(coupon);
    }

}
