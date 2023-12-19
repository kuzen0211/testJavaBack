package com.example.backend.api.services;

import com.example.backend.api.DTO.ProductDTO;
import com.example.backend.api.factory.ProductFactory;
import com.example.backend.api.services.impl.ProductServIceImpl;
import com.example.backend.store.models.ProductEntity;
import com.example.backend.store.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductServIceImpl {

    private final ProductRepository productRepository;
    private final ProductFactory productFactory;

    public ProductService(ProductRepository productRepository,
                          ProductFactory productFactory) {
        this.productRepository = productRepository;
        this.productFactory = productFactory;
    }

    @Override
    public ProductDTO createProduct(ProductEntity entity) {
        return productFactory.makeProduct(productRepository.save(entity));
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        return productRepository.findAll().stream().map(productFactory::makeProduct).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getOneProduct(Long id) {
        ProductEntity entity_Id = productRepository.getReferenceById(id);

        return productFactory.makeProduct(entity_Id);
    }

    @Override
    public ProductDTO editProduct(Long id, ProductEntity entity) {
        ProductEntity entity_update = productRepository.getReferenceById(id);

        entity_update.setName(entity.getName());
        entity_update.setNumber(entity.getNumber());
        entity_update.setPrice(entity.getPrice());
        entity_update.setCategory(entity.getCategory());
        entity_update.setSeller(entity.getSeller());
        entity_update.setDescription_product(entity.getDescription_product());
        entity_update.setCharacteristic_product(entity.getCharacteristic_product());

        return productFactory.makeProduct(productRepository.save(entity_update));
    }

    @Override
    public void deleteIdProduct(Long id) {
        productRepository.deleteById(id);
    }
    @Override
    public void deleteAll(){
        productRepository.deleteAll();
    }
}
