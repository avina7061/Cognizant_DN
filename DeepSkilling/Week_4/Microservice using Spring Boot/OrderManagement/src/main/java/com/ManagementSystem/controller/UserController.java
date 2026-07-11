package com.ManagementSystem.controller;

import com.ManagementSystem.model.User;
import com.ManagementSystem.dto.UserResponseDto;
import com.ManagementSystem.repository.UserRepository;
import com.ManagementSystem.service.OrderClient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderClient orderClient;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserWithOrders(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserResponseDto(user, orderClient.getOrdersByUserId(id));
    }
}