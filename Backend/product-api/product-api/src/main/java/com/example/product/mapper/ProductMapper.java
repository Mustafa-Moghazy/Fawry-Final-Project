package com.example.product.mapper;

import com.example.product.dto.ProductDTO;
import com.example.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.name", target = "categoryName")
    ProductDTO productToProductDTO(Product product);
}
