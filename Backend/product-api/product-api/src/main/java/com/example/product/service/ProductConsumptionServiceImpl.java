package com.example.product.service;

import com.example.product.dto.ProductConsumptionDTO;
import com.example.product.entity.Product;
import com.example.product.entity.ProductConsumption;
import com.example.product.repository.ProductConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductConsumptionServiceImpl implements ProductConsumptionService{
    @Autowired
    private ProductConsumptionRepository pcRepo;
    @Autowired
    private ProductService productService;
    @Override
    public ProductConsumption save(ProductConsumptionDTO productConsumptionDTO) {
        Product product = productService.findByCode(productConsumptionDTO.getProductCode());
        ProductConsumption productConsumption = new ProductConsumption(product, productConsumptionDTO.getOrderCode(), productConsumptionDTO.getQuantityConsumed(), productConsumptionDTO.getConsumedAt());

        return pcRepo.save(productConsumption);
    }
    @Override
    public List<ProductConsumption> saveAll(List<ProductConsumptionDTO> productConsumptionDTOList) {
        List<ProductConsumption> productConsumptionList = new ArrayList<>();
        for (ProductConsumptionDTO dto : productConsumptionDTOList) {
            productConsumptionList.add(this.save(dto));
        }
        return productConsumptionList;
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
}
