package com.example.yarnheart.service;

import com.example.yarnheart.model.Product;

public interface ProductService {

    Product findProductById(Long id);
    Product getProductByName(String name);
    void save(Product product);
}
