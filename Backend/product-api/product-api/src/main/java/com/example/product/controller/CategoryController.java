package com.example.product.controller;

import com.example.product.dto.CategoryDTO;
import com.example.product.entity.Category;
import com.example.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products/category")
public class CategoryController {
    private final CategoryService categoryService;
    @Autowired
    CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }


    @GetMapping("")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }
    @PostMapping("")
    public Category createCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.createCategory(categoryDTO);
    }

}
