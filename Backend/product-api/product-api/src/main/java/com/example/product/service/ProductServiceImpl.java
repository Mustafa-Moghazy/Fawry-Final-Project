package com.example.product.service;

import com.example.product.dto.ProductDTO;
import com.example.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    @Override
    public Product createProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Page<Product> getAllProductsPageable(Pageable pageable) {
        return null;
    }

    @Override
    public List<Product> findByCategoryName(String categoryName) {
        return null;
    }

    @Override
    public Product findByCode(String code) {
        return null;
    }

    @Override
    public Product updateProduct(String code, ProductDTO productDTO) {
        return null;
    }

    @Override
    public void deleteProduct(String code) {

    }
}
