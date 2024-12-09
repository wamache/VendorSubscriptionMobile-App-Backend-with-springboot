package com.MobileApp.Backend.DTO;

import java.time.LocalDateTime;

public class BranchResponse {
    private Long branchId;
    private String address;
    private String contactInfo;
    private LocalDateTime createdAt;
    private String name;
    private BusinessResponse business;

    public BranchResponse(Long branchId, String address, String contactInfo, LocalDateTime createdAt, String name, BusinessResponse business) {
        this.branchId = branchId;
        this.address = address;
        this.contactInfo = contactInfo;
        this.createdAt = createdAt;
        this.name = name;
        this.business = business;
    }

    // Getters and setters


    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
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

    public BusinessResponse getBusiness() {
        return business;
    }

    public void setBusiness(BusinessResponse business) {
        this.business = business;
    }
}

