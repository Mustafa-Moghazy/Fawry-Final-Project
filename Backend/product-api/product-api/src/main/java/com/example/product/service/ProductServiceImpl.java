package com.example.product.service;

import com.example.product.dto.ProductConsumptionDTO;
import com.example.product.dto.ProductDTO;
import com.example.product.entity.Category;
import com.example.product.entity.Product;
import com.example.product.entity.ProductConsumption;
import com.example.product.exception.CategoryNotFoundException;
import com.example.product.exception.CreateProductException;
import com.example.product.exception.ProductNotFoundException;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ProductConsumptionService pcService;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ProductConsumptionService pcService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.pcService = pcService;
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {
        if (!validToSave(productDTO)){
            throw new CreateProductException("Not Valid Data Provided To Create Product");
        }
        Category category = categoryService.findByName(productDTO.getCategoryName());
        Product product = new Product(category,
                UUID.randomUUID().toString(),
                productDTO.getDescription(),
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getImgUrl());

        return productRepository.save(product);
    }

    private boolean validToSave(ProductDTO productDTO) {
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
        Category category = categoryService.findByName(categoryName);
        if( category == null ){
            throw new CategoryNotFoundException("Category with name '" + categoryName + "' Not Found!!");
        }
        return productRepository.findByCategoryName(category.getName());
    }

    @Override
    public Product findByCode(String code) {
        Product theProduct = productRepository.findByCode(code);
        if(theProduct == null)
            throw new ProductNotFoundException("Product with code: '" + code + "' Not Found!!");
        return theProduct;
    }

    @Override
    public Product updateProduct(String code, ProductDTO productDTO) {
        Product theProduct = findByCode(code);
        theProduct.setName(productDTO.getName());
        theProduct.setDescription(productDTO.getDescription());
        theProduct.setPrice(productDTO.getPrice());
        theProduct.setImgUrl(productDTO.getImgUrl());
        return productRepository.save(theProduct);
    }

    @Override
    public void deleteProduct(String code) {
        Product theProduct = productRepository.findByCode(code);
        pcService.deleteProductConsumptionHistory(theProduct);
        productRepository.delete(theProduct);
    }

    @Override
    public ProductConsumption recordProductHistory(ProductConsumptionDTO productConsumptionDTO) {
        Product theProduct = findByCode(productConsumptionDTO.getProductCode());
        return pcService.recordProductHistory(theProduct, productConsumptionDTO);
    }
}
