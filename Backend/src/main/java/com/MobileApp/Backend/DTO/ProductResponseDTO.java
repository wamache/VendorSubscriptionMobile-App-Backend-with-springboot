package com.MobileApp.Backend.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductResponseDTO {

    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime createdAt;

    // Constructor
    public ProductResponseDTO(Long productId, String name, String description, BigDecimal price, LocalDateTime createdAt) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
