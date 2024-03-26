package com.example.product.service;

import com.example.product.dto.ProductConsumptionDTO;
import com.example.product.entity.ProductConsumption;

import java.util.List;

public interface ProductConsumptionService {
    ProductConsumption save(ProductConsumptionDTO productConsumptionDTO);
    List<ProductConsumption> saveAll(List<ProductConsumptionDTO> productConsumptionDTOList);
    List<ProductConsumption> findAll();
    List<ProductConsumption> findByProductCode(String productCode);
    ProductConsumption findByProductCodeAndOrderCode(String productCode, String orderCode);
}
