package com.example.product.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private String description;
    private double price;
    private String imgUrl;
    private String categoryName;
}
