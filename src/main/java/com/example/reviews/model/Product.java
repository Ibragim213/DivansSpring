package com.example.reviews.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String material;
    private double price;
    private String colour;
    private String description;  // Описание товара
    private double depth;        // Глубина (см)
    private double width;        // Ширина (см)
    private double height;       // Высота (см)
    private double weight;       // Вес (кг)

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {} // Пустой конструктор

    public Product(Long id, String name, double price, String material, String colour, String description, double depth, double width, double height, double weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.material = material;
        this.colour = colour;
        this.description = description;
        this.depth = depth;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getMaterial() { return material; }
    public String getColor() { return colour; }
    public String getDescription() { return description; }
    public double getDepth() { return depth; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setMaterial(String material) { this.material = material; }
    public void setColor(String colour) { this.colour = colour; }
    public void setDescription(String description) { this.description = description; }
    public void setDepth(double depth) { this.depth = depth; }
    public void setWidth(double width) { this.width = width; }
    public void setHeight(double height) { this.height = height; }
    public void setWeight(double weight) { this.weight = weight; }

}
