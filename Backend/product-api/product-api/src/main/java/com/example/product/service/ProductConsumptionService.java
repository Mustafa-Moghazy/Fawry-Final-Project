package com.example.product.service;

import com.example.product.dto.ProductConsumptionDTO;
import com.example.product.dto.ProductOrderDTO;
import com.example.product.entity.Product;
import com.example.product.entity.ProductConsumption;

import java.util.List;

public interface ProductConsumptionService {
    ProductConsumption recordProductHistory(Product product, ProductConsumptionDTO productConsumptionDTO);
    List<ProductConsumption> findAll();
    List<ProductConsumption> findByProductCode(String productCode);
    ProductConsumption findByProductCodeAndOrderCode(String productCode, String orderCode);
    void deleteProductConsumption(ProductOrderDTO productOrderDTO);
    void deleteProductConsumptionHistory(Product product);

}
