package com.MobileApp.Backend.DTO;
//
//public class SubscriptionRequest {
//    private Long vendorId;
//    private String plan;
//    private Integer maxProducts;
//    private int additionalBranches;
//
//    // Getters and setters
//
//
//    public Long getVendorId() {
//        return vendorId;
//    }
//
//    public void setVendorId(Long vendorId) {
//        this.vendorId = vendorId;
//    }
//
//    public String getPlan() {
//        return plan;
//    }
//
//    public void setPlan(String plan) {
//        this.plan = plan;
//    }
//
//    public Integer getMaxProducts() {
//        return maxProducts;
//    }
//
//    public void setMaxProducts(Integer maxProducts) {
//        this.maxProducts = maxProducts;
//    }
//
//    public int getAdditionalBranches() {
//        return additionalBranches;
//    }
//
//    public void setAdditionalBranches(int additionalBranches) {
//        this.additionalBranches = additionalBranches;
//    }
//}


//
//public class SubscriptionRequest {
//    private String plan;
//    private Long vendorId;
//
//    // Getters and setters
//
//    public String getPlan() {
//        return plan;
//    }
//
//    public void setPlan(String plan) {
//        this.plan = plan;
//    }
//
//    public Long getVendorId() {
//        return vendorId;
//    }
//
//    public void setVendorId(Long vendorId) {
//        this.vendorId = vendorId;
//    }
//}



import com.MobileApp.Backend.model.Vendor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class SubscriptionRequestDTO {

//    private Vendor vendor;

    @NotBlank(message = "Plan name is required")
    @Size(max = 50, message = "Plan name cannot exceed 50 characters")
    private String plan;
//
//    @NotNull(message = "Price is required")
//    @Min(value = 0, message = "Price must be a positive value")
//    private BigDecimal price;
//
//    @NotNull(message = "MaxProducts is required")
//    @Min(value = 1, message = "MaxProducts must be at least 1")
//    private int maxProducts;

    // Getters and setters


//    public Vendor getVendor() {
//        return vendor;
//    }
//
//    public void setVendor(Vendor vendor) {
//        this.vendor = vendor;
//    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

//    public Double getPrice() {
//        return price;
//    }

//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//    public int getMaxProducts() {
//        return maxProducts;
//    }
//
//    public void setMaxProducts(int maxProducts) {
//        this.maxProducts = maxProducts;
//    }
//
//
//    public BigDecimal getPrice() {
//        return price;
//    }

//    public Vendor getVendorId() {
//        return vendor;
//    }
}

