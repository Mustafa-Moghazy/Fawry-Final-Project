package com.example.coupon.service;

import com.example.coupon.dto.CouponDTO;
import com.example.coupon.entity.Coupon;
import com.example.coupon.exception.FindByCodeException;
import com.example.coupon.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public Coupon updateCoupon(CouponDTO couponDTO) {
        return null;
    }

    @Override
    public Coupon deleteCoupon(CouponDTO couponDTO) {
        return null;
    }
}
