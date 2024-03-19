package com.example.product.service;

import com.example.product.dto.CategoryDTO;
import com.example.product.entity.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(CategoryDTO categoryDTO);
    Category findByName(String name);
    List<Category> getAllCategory();
}
