package com.MobileApp.Backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "max_products")
    private Integer maxProducts;

    private String plan;

    private BigDecimal price;
    private Long vendorId;


    public Subscription(String plan, Integer price, Double maxProducts, Long vendorId) {
    }

    public Subscription() {

    }

//    @ManyToOne
//    @JoinColumn(name = "vendor_id", nullable = false)
//    private Vendor vendor;

    // Getters and setters


    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getMaxProducts() {
        return maxProducts;
    }

    public void setMaxProducts(Integer maxProducts) {
        this.maxProducts = maxProducts;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setVendor(Long vendorId) {
    }

    public Long getVendor() {
        Vendor vendor = new Vendor();
        return vendor.getVendorId();
    }
    }

