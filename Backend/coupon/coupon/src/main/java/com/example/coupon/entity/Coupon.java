package com.example.coupon.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name="coupons")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private Date expiryDate;
    private String valueType;
    private double value;
    private long maxNumberOfUsages;
    private long currentNumberOfUsages;
    private boolean valid;

    public Coupon(String code, Date expiryDate, String valueType, double value, long maxNumberOfUsages) {
        this.code = code;
        this.expiryDate = expiryDate;
        this.valueType = valueType;
        this.value = value;
        this.maxNumberOfUsages = maxNumberOfUsages;
        this.currentNumberOfUsages = 0;
        this.valid = true;
    }

    public Coupon() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public long getMaxNumberOfUsages() {
        return maxNumberOfUsages;
    }

    public void setMaxNumberOfUsages(long maxNumberOfUsages) {
        this.maxNumberOfUsages = maxNumberOfUsages;
    }

    public long getCurrentNumberOfUsages() {
        return currentNumberOfUsages;
    }

    public void setCurrentNumberOfUsages(long currentNumberOfUsages) {
        this.currentNumberOfUsages = currentNumberOfUsages;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
