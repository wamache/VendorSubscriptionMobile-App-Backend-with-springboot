package com.MobileApp.Backend.DTO;

import java.time.LocalDateTime;

public class PaymentResponse {
    private Long paymentId;
    private Double amount;
    private LocalDateTime paymentDate;
    private String paymentMethod;
    private VendorResponse vendor;

    public PaymentResponse(Long paymentId, Double amount, LocalDateTime paymentDate, String paymentMethod, VendorResponse vendor) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.vendor = vendor;
    }

    // Getters and setters

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public VendorResponse getVendor() {
        return vendor;
    }

    public void setVendor(VendorResponse vendor) {
        this.vendor = vendor;
    }
}
