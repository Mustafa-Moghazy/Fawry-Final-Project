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
    private long orderId;
    private int quantityConsumed;
    private Date consumedAt;
}
