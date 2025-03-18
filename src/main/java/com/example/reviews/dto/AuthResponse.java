package com.example.reviews.dto;

public class AuthResponse {

    private String token; // Токен, который будет передан клиенту

    // Конструктор для инициализации токена
    public AuthResponse(String token) {
        this.token = token;
    }

    // Геттер для получения токена
    public String getToken() {
        return token;
    }

    // Сеттер для установки токена
    public void setToken(String token) {
        this.token = token;
    }
}
