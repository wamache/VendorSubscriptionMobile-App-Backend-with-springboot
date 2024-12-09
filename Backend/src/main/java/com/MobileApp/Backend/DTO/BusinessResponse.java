package com.MobileApp.Backend.DTO;

import java.time.LocalDateTime;

public class BusinessResponse {
    private Long businessId;
    private String address;
    private String contactInfo;
    private LocalDateTime createdAt;
    private String name;
    private Long vendorId;

    public BusinessResponse(Long businessId, String address, String contactInfo, LocalDateTime createdAt, String name, Long vendorId) {
        this.businessId = businessId;
        this.address = address;
        this.contactInfo = contactInfo;
        this.createdAt = createdAt;
        this.name = name;
        this.vendorId = vendorId;
    }

    // Getters and setters


    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }
}

