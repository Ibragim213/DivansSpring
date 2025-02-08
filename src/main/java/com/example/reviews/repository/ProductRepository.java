package com.example.reviews.repository;

import com.example.reviews.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE " +
            "(:type IS NULL OR LOWER(p.type) = LOWER(:type)) AND " +
            "(:material IS NULL OR LOWER(p.material) = LOWER(:material)) AND " +
            "(:color IS NULL OR LOWER(p.color) = LOWER(:color)) AND " +
            "(:priceFrom IS NULL OR p.price >= :priceFrom) AND " +
            "(:priceTo IS NULL OR p.price <= :priceTo) AND " +
            "(:availability IS NULL OR LOWER(p.availability) = LOWER(:availability))")
    List<Product> findByFilters(
            @Param("type") String type,
            @Param("material") String material,
            @Param("color") String color,
            @Param("priceFrom") Double priceFrom,
            @Param("priceTo") Double priceTo,
            @Param("availability") String availability);

}

