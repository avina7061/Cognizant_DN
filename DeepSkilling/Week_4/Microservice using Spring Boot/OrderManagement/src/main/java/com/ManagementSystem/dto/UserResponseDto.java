package com.ManagementSystem.dto;


import java.util.List;

import com.ManagementSystem.model.User;
import com.ManagementSystem.dto.OrderDto;

public class UserResponseDto {
    private User user;
    private List<OrderDto> orders;

    public void UserResponseDTO(User user, List<OrderDto> orders) {
        this.user = user;
        this.orders = orders;
    }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public List<OrderDto> getOrders() { return orders; }
    public void setOrders(List<OrderDto> orders) { this.orders = orders; }
}