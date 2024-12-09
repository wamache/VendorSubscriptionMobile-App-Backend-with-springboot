package com.MobileApp.Backend.DTO;

import java.time.LocalDateTime;

public class VendorResponse {

//    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;

    public VendorResponse(String name, String email, String phoneNumber, LocalDateTime createdAt) {
//        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
    }

    public VendorResponse(Long vendorId, String name, String email, String phoneNumber, String passwordHash, LocalDateTime createdAt) {
    }

    // Getters only
//    public int getId() {
//        return id;
//    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
