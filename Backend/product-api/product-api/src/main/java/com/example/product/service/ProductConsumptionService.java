package com.example.product.service;

import com.example.product.dto.ProductConsumptionDTO;
import com.example.product.dto.ProductOrderDTO;
import com.example.product.entity.Product;
import com.example.product.entity.ProductConsumption;

import java.util.List;

public interface ProductConsumptionService {
    ProductConsumption recordProductHistory(Product product, ProductConsumptionDTO productConsumptionDTO);
    List<ProductConsumptionDTO> findAll();
    List<ProductConsumptionDTO> findByProductCode(String productCode);
    ProductConsumptionDTO findByProductCodeAndOrderCode(String productCode, String orderCode);
    void deleteProductConsumption(ProductOrderDTO productOrderDTO);
    void deleteProductConsumptionHistory(Product product);

}
