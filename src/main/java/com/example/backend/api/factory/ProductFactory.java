package com.example.backend.api.factory;

import com.example.backend.api.DTO.ProductDTO;
import com.example.backend.store.models.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductFactory {

    public ProductDTO makeProduct(ProductEntity entity){
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(entity.getId());
        productDTO.setName(entity.getName());
        productDTO.setCategory(entity.getCategory());
        productDTO.setSeller(entity.getSeller());
        productDTO.setNumber(entity.getNumber());
        productDTO.setPrice(entity.getPrice());
        productDTO.setCharacteristic_product(entity.getCharacteristic_product());
        productDTO.setDescription_product(entity.getDescription_product());
        productDTO.setCreateDate(entity.getCreateDate());

        return productDTO;
    }
}
