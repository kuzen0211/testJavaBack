package com.example.backend.api.services.impl;

import com.example.backend.api.DTO.ProductDTO;
import com.example.backend.store.models.ProductEntity;

import java.util.List;

public interface ProductServIceImpl {

    ProductDTO createProduct(ProductEntity entity);
    List<ProductDTO> getAllProduct();
    ProductDTO getOneProduct(Long id);
    ProductDTO editProduct(Long id, ProductEntity entity);
    void deleteIdProduct(Long id);
    void deleteAll();
}
