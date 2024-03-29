package com.example.product.service;

import com.example.product.dto.ProductConsumptionDTO;
import com.example.product.entity.Product;
import com.example.product.entity.ProductConsumption;
import com.example.product.repository.ProductConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ProductConsumptionServiceImpl implements ProductConsumptionService{
    @Autowired
    private ProductConsumptionRepository pcRepo;

    @Override
    public ProductConsumption recordProductHistory(Product theproduct, ProductConsumptionDTO productConsumptionDTO) {
        ProductConsumption productConsumption = new ProductConsumption(theproduct, productConsumptionDTO.getOrderCode(), productConsumptionDTO.getQuantityConsumed(), new Date());
        return pcRepo.save(productConsumption);
    }

    @Override
    public List<ProductConsumption> findAll() {
        return pcRepo.findAll();
    }

    @Override
    public List<ProductConsumption> findByProductCode(String productCode) {
        return pcRepo.findByProductCode(productCode);
    }

    @Override
    public ProductConsumption findByProductCodeAndOrderCode(String productCode, String orderCode) {
        return pcRepo.findByProductCodeAndOrderCode(productCode, orderCode);
    }

    @Override
    public void deleteProductConsumption(ProductConsumptionDTO productConsumptionDTO) {
        ProductConsumption productConsumption = findByProductCodeAndOrderCode(productConsumptionDTO.getProductCode(), productConsumptionDTO.getOrderCode());
        pcRepo.delete(productConsumption);
    }

    @Override
    public void deleteProductConsumptionHistory(String code) {
        pcRepo.deleteAllByProduct_Code(code);
    }
}
