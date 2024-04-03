package com.example.product.mapper;

import com.example.product.dto.ProductConsumptionDTO;
import com.example.product.entity.ProductConsumption;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductConsumptionMapper {

    @Mapping(source = "product.code", target = "productCode")
    ProductConsumptionDTO entityToDTO(ProductConsumption productConsumption);
}
