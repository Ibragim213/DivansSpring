package com.example.reviews.controller;

import com.example.reviews.model.Product;
import com.example.reviews.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Получить все товары
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Получить товар по ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Product>> getFilteredProducts(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String material,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Double priceFrom,
            @RequestParam(required = false) Double priceTo,
            @RequestParam(required = false) String availability) {

        List<Product> products = productService.getFilteredProducts(type, material, color, priceFrom, priceTo, availability);

        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();  // Возвращаем 204, если товаров нет
        }

        return ResponseEntity.ok(products);
    }


}
