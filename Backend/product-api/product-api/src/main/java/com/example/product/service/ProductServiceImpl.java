package com.example.product.service;

import com.example.product.dto.ProductDTO;
import com.example.product.entity.Category;
import com.example.product.entity.Product;
import com.example.product.exception.CreateProductException;
import com.example.product.exception.ProductNotFoundEception;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
    @Override
    public Product createProduct(ProductDTO productDTO) {
        if (!isProductValidToSave(productDTO)){
            throw new CreateProductException("Not Valid Data Provided To Create Product");
        }
        Category category = categoryService.findByName(productDTO.getCategoryName());
        Product product = new Product();
        product.setCategory(category);
        product.setCode(UUID.randomUUID().toString());
        product.setDescription(productDTO.getDescription());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setImgUrl(productDTO.getImgUrl());

        return productRepository.save(product);
    }

    private boolean isProductValidToSave(ProductDTO productDTO) {
        return productDTO != null &&
                !productDTO.getCategoryName().isEmpty() &&
                !productDTO.getName().isEmpty() &&
                productDTO.getPrice() > 0 &&
                !productDTO.getImgUrl().isEmpty();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> getAllProductsPageable(Pageable pageable) {

        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> findByCategoryName(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

    @Override
    public Product findByCode(String code) {
        Product theProduct = productRepository.findByCode(code);
        if(theProduct == null)
            throw new ProductNotFoundEception("Product with code: "+code+" Not Found!!");
        return productRepository.findByCode(code);
    }

    @Override
    public Product updateProduct(String code, ProductDTO productDTO) {
        Product theProduct = productRepository.findByCode(code);
        if(theProduct == null)
            throw new ProductNotFoundEception("Product with code: "+code+" Not Found!!");

        return createProduct(productDTO);
    }

    @Override
    public void deleteProduct(String code) {
        Product theProduct = productRepository.findByCode(code);
        if(theProduct == null)
            throw new ProductNotFoundEception("Product with code: "+code+" Not Found!!");
        productRepository.delete(theProduct);
    }
}
