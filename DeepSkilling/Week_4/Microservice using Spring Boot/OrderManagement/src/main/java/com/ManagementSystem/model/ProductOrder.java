package com.ManagementSystem.model;



import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    private Double price;
    private Long userId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}