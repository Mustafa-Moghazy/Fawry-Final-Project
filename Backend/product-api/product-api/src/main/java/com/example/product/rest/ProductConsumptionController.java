package com.example.product.rest;

import com.example.product.dto.ProductConsumptionDTO;
import com.example.product.dto.ProductOrderDTO;
import com.example.product.entity.ProductConsumption;
import com.example.product.service.ProductConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductConsumptionController {
    @Autowired
    private ProductConsumptionService pcService;

    @GetMapping("history")
    public List<ProductConsumption> getAllProductsHistory(){
        return pcService.findAll();
    }

    @GetMapping("history/{code}")
    public List<ProductConsumption> getProductHistory(@PathVariable String code){
        return pcService.findByProductCode(code);
    }

    @GetMapping("history/product-order")
    public ProductConsumption getProductOrder(@RequestBody ProductOrderDTO productOrderDTO){
        return pcService.findByProductCodeAndOrderCode(productOrderDTO.getProductCode(), productOrderDTO.getOrderCode());
    }

    @DeleteMapping("history/product-order")
    public void deleteProductConsumptionRecord(@RequestBody ProductOrderDTO productOrderDTO){
        pcService.deleteProductConsumption(productOrderDTO);
    }

}
