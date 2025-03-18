package com.example.reviews.controller;

import com.example.reviews.dto.UserDTO;
import com.example.reviews.model.User;
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

    // Получение пользователя по ID
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Получение текущего пользователя
    @GetMapping("/me")
    public UserDTO getCurrentUser(@RequestHeader("Authorization") String token) {
        String email = jwtUtil.extractUsername(token.substring(7)); // Убираем "Bearer "
        User user = userService.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        return userService.convertToDTO(user);
    }
}
