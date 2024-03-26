package com.example.coupon.service;

import com.example.coupon.dto.CouponDTO;
import com.example.coupon.entity.Coupon;

import java.util.List;

public interface CouponService {
    List<Coupon> findAll();
    Coupon findByCode(String Code);
    Coupon createCoupon(CouponDTO couponDTO);
    Coupon updateCoupon(CouponDTO couponDTO);
    void deleteCoupon(String code);
    boolean ISValidToSave(CouponDTO couponDTO);
    void decrementNumberOfUsages(String couponCode);
}
