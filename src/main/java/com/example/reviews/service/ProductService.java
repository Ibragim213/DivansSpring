package com.example.reviews.service;

import com.example.reviews.model.Product;
import com.example.reviews.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }




    // Метод для фильтрации товаров
    public List<Product> getFilteredProducts(
            String type, String material, String color,
            Double priceFrom, Double priceTo, String availability) {

        // Логика для обработки пустых значений
        if (type != null && type.isEmpty()) type = null;
        if (material != null && material.isEmpty()) material = null;
        if (color != null && color.isEmpty()) color = null;
        if (availability != null && availability.isEmpty()) availability = null;

        return productRepository.findByFilters(type, material, color, priceFrom, priceTo, availability);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Товар не найден"));
    }
}
