package com.example.product.repository;

import com.example.product.entity.ProductConsumption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductConsumptionRepository extends JpaRepository<ProductConsumption, Long> {
    List<ProductConsumption> findByProductCode(String productCode);
    ProductConsumption findByProductCodeAndOrderCode(String productCode, String orderCode);
}
