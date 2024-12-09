package com.MobileApp.Backend.service;

import com.MobileApp.Backend.DTO.ProductRequestDTO;
import com.MobileApp.Backend.DTO.ProductResponseDTO;
import com.MobileApp.Backend.model.Product;
import com.MobileApp.Backend.model.Subscription;
import com.MobileApp.Backend.model.Vendor;
import com.MobileApp.Backend.repository.ProductRepository;
import com.MobileApp.Backend.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    // Method to add a product for a vendor
    public ProductResponseDTO addProduct(Long vendorId, ProductRequestDTO productDTO) {
        Vendor vendor = new Vendor();
        Optional<Subscription> subscriptionOpt = subscriptionRepository.findByVendorId(vendorId);

        if (!subscriptionOpt.isPresent()) {
            throw new IllegalArgumentException("Vendor not found or does not have a subscription.");
        }

        Subscription subscription = subscriptionOpt.get();
//        Vendor vendor = new Vendor();
//        int currentProductCount = productRepository.countByBusinessVendorId(vendorId);
        int currentProductCount = productRepository.countByBusinessVendor(vendor);


        // Check the subscription type and apply limits
        switch (subscription.getPlan().toLowerCase()) {
            case "starter":
                if (currentProductCount >= 10) {
                    throw new IllegalArgumentException("Subscription limit reached for 'Starter' plan. Max 10 products allowed.");
                }
                break;
            case "pro":
                if (currentProductCount >= 100) {
                    throw new IllegalArgumentException("Subscription limit reached for 'Pro' plan. Max 100 products allowed.");
                }
                break;
            case "enterprise":
                // No limit on product count for 'Enterprise' plan
                break;
            default:
                throw new IllegalArgumentException("Invalid subscription plan.");
        }

        // If all checks pass, add the product
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        //product.setBusiness(subscription.getVendor().getBusiness()); // Assuming Vendor -> Business relation

        Product savedProduct = productRepository.save(product);

        // Return ProductResponseDTO with product details
        return new ProductResponseDTO(
                (long) savedProduct.getProductId(),
                savedProduct.getName(),
                savedProduct.getDescription(),
                savedProduct.getPrice(),
                savedProduct.getCreatedAt()
        );
    }
}
