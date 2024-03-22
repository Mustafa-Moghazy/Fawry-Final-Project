package com.example.product.repository;

import com.example.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryName(String categoryName);
    Product findByCode(String code);
}
