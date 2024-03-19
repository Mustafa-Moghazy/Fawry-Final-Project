package com.example.product.service;

import com.example.product.dto.CategoryDTO;
import com.example.product.entity.Category;
import com.example.product.exception.CreateCategoryException;
import com.example.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        if(categoryDTO == null || categoryDTO.getCategoryName().isEmpty() )
            throw new CreateCategoryException("Not Valid Data Provided For Create Category");
        Category category = new Category();
        category.setName(categoryDTO.getCategoryName());
        return categoryRepository.save(category);
    }
    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

}
