package com.example.yarnheart.service;

import com.example.yarnheart.exception.ProductNotFoundException;
import com.example.yarnheart.model.Product;
import com.example.yarnheart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findProductById(Long id){
        return productRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException(id)
        );
    }

    @Override
    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
