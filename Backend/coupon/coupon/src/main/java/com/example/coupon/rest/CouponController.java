package com.example.coupon.rest;

import com.example.coupon.dto.CouponDTO;
import com.example.coupon.entity.Coupon;
import com.example.coupon.service.CouponService;
import com.example.coupon.service.CouponServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CouponController {
    @Autowired
    CouponService couponService;

    @GetMapping("coupons")
    public List<Coupon> getAllCoupons(){
        return couponService.findAll();
    }
    @GetMapping("coupons/{code}")
    public Coupon findByCode(@PathVariable String code){
        return couponService.findByCode(code);
    }
    @PostMapping("coupons")
    public Coupon createCoupon(@RequestBody CouponDTO couponDTO){
        return couponService.createCoupon(couponDTO);
    }

    @DeleteMapping("coupons/{code}")
    public void deleteCoupon(@PathVariable String code){
        couponService.deleteCoupon(code);
    }
    @PutMapping("coupons")
    public Coupon updateCoupon(@RequestBody CouponDTO couponDTO){
        return couponService.updateCoupon(couponDTO);
    }
}
