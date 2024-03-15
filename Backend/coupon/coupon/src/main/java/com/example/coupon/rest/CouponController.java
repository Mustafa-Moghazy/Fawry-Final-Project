package com.example.coupon.rest;

import com.example.coupon.dto.CouponDTO;
import com.example.coupon.entity.Coupon;
import com.example.coupon.service.CouponServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CouponController {
    @Autowired
    CouponServiceImpl couponService;

    @PostMapping("coupons")
    public Coupon createCoupon(@RequestBody CouponDTO couponDTO){
        return couponService.createCoupon(couponDTO);
    }
}
