package com.example.product.controller;

import com.example.product.dto.ProductConsumptionDTO;
import com.example.product.dto.ProductOrderDTO;
import com.example.product.entity.ProductConsumption;
import com.example.product.service.ProductConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products/history")
public class ProductConsumptionController {
    private final ProductConsumptionService pcService;
    @Autowired
    ProductConsumptionController(ProductConsumptionService productConsumptionService){
        this.pcService = productConsumptionService;
    }

    @GetMapping("")
    public List<ProductConsumptionDTO> getAllProductsHistory(){
        return pcService.findAll();
    }

    @GetMapping("{code}")
    public List<ProductConsumptionDTO> getProductHistory(@PathVariable String code){
        return pcService.findByProductCode(code);
    }

    @GetMapping("product-order")
    public ProductConsumptionDTO getProductOrder(@RequestBody ProductOrderDTO productOrderDTO){
        return pcService.findByProductCodeAndOrderCode(productOrderDTO.getProductCode(), productOrderDTO.getOrderCode());
    }

    @DeleteMapping("product-order")
    public void deleteProductConsumptionRecord(@RequestBody ProductOrderDTO productOrderDTO){
        pcService.deleteProductConsumption(productOrderDTO);
    }

}
