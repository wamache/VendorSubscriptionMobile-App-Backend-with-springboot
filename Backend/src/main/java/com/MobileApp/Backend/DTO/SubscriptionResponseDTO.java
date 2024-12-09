package com.MobileApp.Backend.DTO;




import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SubscriptionResponseDTO {

    private int id;
    private String plan;
    private BigDecimal price;
    private int maxProducts;
    private LocalDateTime createdAt;

    public SubscriptionResponseDTO(int id, String plan, BigDecimal price, int maxProducts, LocalDateTime createdAt) {
        this.id = id;
        this.plan = plan;
        this.price = price;
        this.maxProducts = maxProducts;
        this.createdAt = createdAt;
    }

    public SubscriptionResponseDTO(Long subscriptionId, String plan, Double price, Integer maxProducts, LocalDateTime createdAt) {
    }

    // Getters only
    public int getId() {
        return id;
    }

    public String getPlan() {
        return plan;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getMaxProducts() {
        return maxProducts;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
