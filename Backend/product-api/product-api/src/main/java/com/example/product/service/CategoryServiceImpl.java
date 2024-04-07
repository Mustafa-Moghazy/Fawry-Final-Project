package com.example.product.service;

import com.example.product.dto.CategoryDTO;
import com.example.product.entity.Category;
import com.example.product.exception.CategoryNotFoundException;
import com.example.product.exception.CreateCategoryException;
import com.example.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    @Autowired
    CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        if(categoryDTO == null || categoryDTO.getCategoryName().isEmpty() ) {
            throw new CreateCategoryException("Not Valid Data Provided For Create Category");
        }
        Category category = new Category(categoryDTO.getCategoryName());
        return categoryRepository.save(category);
    }
    @Override
    public Category findByName(String name) {
        Category category = categoryRepository.findByName(name);
        if(category == null)
            throw new CategoryNotFoundException("Category With Name: '" + name + "' Not Found!!");
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

}
