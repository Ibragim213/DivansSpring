package com.example.reviews.model;

import jakarta.persistence.*;


@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String old_price;
    private String name;
    private String material;
    private double price;
    private String color;  // Поменяли на 'color' для согласованности
    private String description;  // Описание товара
    private double depth;        // Глубина (см)
    private double width;        // Ширина (см)
    private double height;       // Высота (см)
    private double weight;// Вес (кг)
    private String image;
    private String type;  // Добавляем поле для типа товара (например, кресло или диван)
    private String availability;  // Добавляем поле для статуса наличия (например, в наличии или под заказ)

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {} // Пустой конструктор

    public Product(Long id, String name, double price, String material, String color, String description,
                   double depth, double width, double height, double weight, String type, String availability, String old_price , String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.material = material;
        this.color = color;
        this.description = description;
        this.depth = depth;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.type = type;
        this.availability = availability;
        this.old_price = old_price;
        this.image = image;


    }

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getMaterial() { return material; }
    public String getColor() { return color; }
    public String getDescription() { return description; }
    public double getDepth() { return depth; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public double getWeight() { return weight; }
    public String getType() { return type; }  // Геттер для типа
    public String getAvailability() { return availability; }  // Геттер для наличия
    public String getOld_price() { return old_price; }
    public String getImage() { return image; }


    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setMaterial(String material) { this.material = material; }
    public void setColor(String color) { this.color = color; }
    public void setDescription(String description) { this.description = description; }
    public void setDepth(double depth) { this.depth = depth; }
    public void setWidth(double width) { this.width = width; }
    public void setHeight(double height) { this.height = height; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setType(String type) { this.type = type; }  // Сеттер для типа
    public void setAvailability(String availability) { this.availability = availability; }  // Сеттер для наличия
    public void setOld_price(String old_price) { this.old_price = old_price; }
    public void setImage(String image) { this.image = image; }
}
