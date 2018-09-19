package com.example.yarnheart.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Brak produktu o id: " + id);
    }
}
