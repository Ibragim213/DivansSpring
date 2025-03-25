package com.example.reviews.controller;

import com.example.reviews.dto.UserDTO;
import com.example.reviews.service.UserService;
import com.example.reviews.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    // Получение всех пользователей
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/api/users/{id}")
    public UserDTO getUserProfile(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
