package com.example.product.rest;

import com.example.product.dto.ProductDTO;
import com.example.product.entity.Product;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("")
    public Product createProduct(@RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }
}
