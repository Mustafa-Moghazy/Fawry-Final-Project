package com.example.product.controller;

import com.example.product.dto.ProductDTO;
import com.example.product.dto.ProductConsumptionDTO;
import com.example.product.entity.Product;
import com.example.product.entity.ProductConsumption;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;
    @Autowired
    ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("")
    public Product createProduct(@RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }
    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/pageable")
    public Page<Product> getAllProductsPageable(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size,
                                                @RequestParam(defaultValue = "id") String sort) {
        return productService.getAllProductsPageable(PageRequest.of(page, size, Sort.by(sort)));
    }

    @GetMapping("/category/{categoryName}")
    public List<Product> getByCategoryName(@PathVariable String categoryName) {
        return productService.findByCategoryName(categoryName);
    }

    @GetMapping("/{code}")
    public Product getByCode(@PathVariable String code) {
        return productService.findByCode(code);
    }

    @PutMapping("/{code}")
    public Product updateProduct(@PathVariable String code, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(code, productDTO);
    }

    @DeleteMapping("/{code}")
    public void deleteProduct(@PathVariable String code) {
        productService.deleteProduct(code);
    }

    @PostMapping("history")
    public ProductConsumption recordProductHistory(@RequestBody ProductConsumptionDTO productConsumptionDTO) {
        return productService.recordProductHistory(productConsumptionDTO);
    }


}
