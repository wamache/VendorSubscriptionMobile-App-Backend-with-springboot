package com.MobileApp.Backend.DTO;

public class PaymentRequest {
    private Long vendorId;
    private Double amount;
    private String paymentMethod; // Optional (default to 'mpesa daraja')

    // Getters and setters


    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
