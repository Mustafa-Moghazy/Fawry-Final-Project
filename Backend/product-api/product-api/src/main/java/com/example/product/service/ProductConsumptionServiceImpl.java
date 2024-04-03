package com.example.product.service;

import com.example.product.dto.ProductConsumptionDTO;
import com.example.product.dto.ProductOrderDTO;
import com.example.product.entity.Product;
import com.example.product.entity.ProductConsumption;
import com.example.product.mapper.ProductConsumptionMapper;
import com.example.product.repository.ProductConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductConsumptionServiceImpl implements ProductConsumptionService{
    private final ProductConsumptionRepository pcRepo;
    private final ProductConsumptionMapper pcMapper;

    @Autowired
    public ProductConsumptionServiceImpl(ProductConsumptionRepository pcRepo, ProductConsumptionMapper pcMapper) {
        this.pcRepo = pcRepo;
        this.pcMapper = pcMapper;
    }


    @Override
    public ProductConsumption recordProductHistory(Product theproduct, ProductConsumptionDTO productConsumptionDTO) {
        ProductConsumption productConsumption = new ProductConsumption(theproduct, productConsumptionDTO.getOrderCode(), productConsumptionDTO.getQuantityConsumed(), new Date());
        return pcRepo.save(productConsumption);
    }

    @Override
    public List<ProductConsumptionDTO> findAll() {
        List<ProductConsumption> productConsumptions = pcRepo.findAll();
        return productConsumptions.stream()
                .map(pcMapper::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductConsumptionDTO> findByProductCode(String productCode) {
        List<ProductConsumption> productConsumptions = pcRepo.findByProductCode(productCode);
        return productConsumptions.stream()
                .map(pcMapper::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductConsumptionDTO findByProductCodeAndOrderCode(String productCode, String orderCode) {
        ProductConsumption productConsumption = pcRepo.findByProductCodeAndOrderCode(productCode, orderCode);
        return pcMapper.entityToDTO(productConsumption);
    }

    @Override
    public void deleteProductConsumption(ProductOrderDTO productOrderDTO) {
        ProductConsumption productConsumption = pcRepo.findByProductCodeAndOrderCode(productOrderDTO.getProductCode(), productOrderDTO.getOrderCode());
        pcRepo.delete(productConsumption);
    }

    @Override
    public void deleteProductConsumptionHistory(Product product) {
        List<ProductConsumption> productConsumptions = pcRepo.findByProductCode(product.getCode());
        pcRepo.deleteAll(productConsumptions);
    }
}
