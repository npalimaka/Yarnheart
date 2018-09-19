package com.example.yarnheart.service;

import com.example.yarnheart.exception.ProductNotFoundException;
import com.example.yarnheart.model.Product;
import com.example.yarnheart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findProductById(Long id){
        return productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException(id)
        );
    }
}
