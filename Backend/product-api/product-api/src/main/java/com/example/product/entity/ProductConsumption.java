package com.example.product.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "product_consumption")
public class ProductConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String orderCode;
    private int quantityConsumed;
    private Date consumedAt;

    public ProductConsumption(Product product, String orderCode, int quantityConsumed, Date consumedAt) {
        this.product = product;
        this.orderCode = orderCode;
        this.quantityConsumed = quantityConsumed;
        this.consumedAt = consumedAt;
    }

    public ProductConsumption() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getQuantityConsumed() {
        return quantityConsumed;
    }

    public void setQuantityConsumed(int quantityConsumed) {
        this.quantityConsumed = quantityConsumed;
    }

    public Date getConsumedAt() {
        return consumedAt;
    }

    public void setConsumedAt(Date consumedAt) {
        this.consumedAt = consumedAt;
    }
}
