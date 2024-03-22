package com.example.product.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductConsumptionDTO {
    private String  productCode;
    private String orderCode;
    private int quantityConsumed;
    Date consumedAt;
}
