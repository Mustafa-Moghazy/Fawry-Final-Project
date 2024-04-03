package com.example.product.mapper;

import com.example.product.dto.ProductConsumptionDTO;
import com.example.product.entity.Product;
import com.example.product.entity.ProductConsumption;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-03T14:17:09+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProductConsumptionMapperImpl implements ProductConsumptionMapper {

    @Override
    public ProductConsumptionDTO entityToDTO(ProductConsumption productConsumption) {
        if ( productConsumption == null ) {
            return null;
        }

        ProductConsumptionDTO productConsumptionDTO = new ProductConsumptionDTO();

        productConsumptionDTO.setProductCode( productConsumptionProductCode( productConsumption ) );
        productConsumptionDTO.setOrderCode( productConsumption.getOrderCode() );
        productConsumptionDTO.setQuantityConsumed( productConsumption.getQuantityConsumed() );
        productConsumptionDTO.setConsumedAt( productConsumption.getConsumedAt() );

        return productConsumptionDTO;
    }

    private String productConsumptionProductCode(ProductConsumption productConsumption) {
        if ( productConsumption == null ) {
            return null;
        }
        Product product = productConsumption.getProduct();
        if ( product == null ) {
            return null;
        }
        String code = product.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }
}
