package com.ManagementSystem.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.ManagementSystem.model.ProductOrder;

import java.util.List;

public interface OrderRepository extends JpaRepository<ProductOrder, Long> {
    List<ProductOrder> findByUserId(Long userId);
}