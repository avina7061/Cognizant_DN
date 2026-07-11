package com.ManagementSystem.service;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.ManagementSystem.dto.OrderDto;
import java.util.List;

@FeignClient(name = "order-service", url = "http://localhost:8082")
public interface OrderClient {
    @GetMapping("/orders/user/{userId}")
    List<OrderDto> getOrdersByUserId(@PathVariable("userId") Long userId);
}