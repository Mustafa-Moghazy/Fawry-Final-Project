package com.example.product.service;

import com.example.product.dto.ProductConsumptionDTO;
import com.example.product.dto.ProductDTO;
import com.example.product.entity.Product;
import com.example.product.entity.ProductConsumption;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductDTO productDTO);
    List<Product> getAllProducts();
    Page<Product> getAllProductsPageable(Pageable pageable);
    List<Product> findByCategoryName(String categoryName);
    Product findByCode(String code);
    Product updateProduct(String code, ProductDTO productDTO);
    void deleteProduct(String code);
    ProductConsumption recordProductHistory(ProductConsumptionDTO productConsumptionDTO);

}
