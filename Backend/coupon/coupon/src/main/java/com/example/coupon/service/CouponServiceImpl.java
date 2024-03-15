package com.example.coupon.service;

import com.example.coupon.dto.CouponDTO;
import com.example.coupon.entity.Coupon;
import com.example.coupon.exception.CreateCouponException;
import com.example.coupon.exception.FindByCodeException;
import com.example.coupon.repository.CouponRepository;
import jakarta.transaction.Transactional;
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
        Coupon theCoupon = couponRepo.findByCode(code);
        if (theCoupon == null)
            throw new FindByCodeException("Coupon with code: " + code + "Not Found!!!");
        return theCoupon;
    }

    @Override
    public Coupon createCoupon(CouponDTO couponDTO) {
        Coupon theCoupon = couponRepo.findByCode(couponDTO.getCode());
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
        Coupon theCoupon = findByCode(couponDTO.getCode());
        if (ISValidToSave(couponDTO)) {
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
        Coupon theCoupon = findByCode(code);
        if (theCoupon != null) {
            couponRepo.deleteByCode(code);
        }
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
