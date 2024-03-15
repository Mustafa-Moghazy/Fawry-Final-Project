package com.example.coupon.service;

import com.example.coupon.dto.CouponDTO;
import com.example.coupon.entity.Coupon;
import com.example.coupon.exception.CreateCouponException;
import com.example.coupon.exception.FindByCodeException;
import com.example.coupon.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CouponServiceImpl implements CouponService{
    @Autowired
    CouponRepository couponRepo;
    @Override
    public List<Coupon> findAll() {
        return couponRepo.findAll();
    }

    @Override
    public Coupon findByCode(String code) {
        return couponRepo.findByCode(code);
    }

    @Override
    public Coupon createCoupon(CouponDTO couponDTO) {
        Coupon theCoupon = findByCode(couponDTO.getCode());
        if (theCoupon != null){
            throw new FindByCodeException("Coupon With Code: " + couponDTO.getCode() +" Already Exist");
        }
        if(ISValidToSave(couponDTO)){
            Coupon newCoupon = new Coupon(couponDTO.getCode(), couponDTO.getExpiryDate(), couponDTO.getValueType(), couponDTO.getValue(), couponDTO.getMaxNumberOfUsages());
            return couponRepo.save(newCoupon);
        }else {
            throw new CreateCouponException("Not Valid Data Provided");
        }
    }

    @Override
    public Coupon updateCoupon(CouponDTO couponDTO) {
        return null;
    }

    @Override
    public Coupon deleteCoupon(CouponDTO couponDTO) {
        return null;
    }
    @Override
    public boolean ISValidToSave(CouponDTO coupon){
        return coupon != null &&
                coupon.getCode() != null &&
                !coupon.getCode().isEmpty() &&
                coupon.getMaxNumberOfUsages() > 0 &&
                coupon.getValue() > 0 &&
                (coupon.getValueType().toUpperCase().equals("FIXED") ||
                        coupon.getValueType().toUpperCase().equals("PERCENTAGE")) &&
                coupon.getExpiryDate().after(new Date());
    }
}
