package com.example.coupon.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "consumption_history")
public class ConsumptionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String orderCode;
    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;
    private Date consumptionDate;

    public ConsumptionHistory() {
    }

    public ConsumptionHistory(String orderCode, Coupon theCoupon, Date date) {
        this.coupon = theCoupon;
        this.orderCode = orderCode;
        this.consumptionDate = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Date getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(Date consumptionDate) {
        this.consumptionDate = consumptionDate;
    }
}
