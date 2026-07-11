package com.ManagementSystem.controller;

import com.ManagementSystem.model.ProductOrder;

import com.ManagementSystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public ProductOrder createOrder(@RequestBody ProductOrder order) {
        return orderRepository.save(order);
    }

    @GetMapping("/user/{userId}")
    public List<ProductOrder> getOrdersByUserId(@PathVariable Long userId) {
        return orderRepository.findByUserId(userId);
    }
}