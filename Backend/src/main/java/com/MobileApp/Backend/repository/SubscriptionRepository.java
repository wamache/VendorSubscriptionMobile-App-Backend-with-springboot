package com.MobileApp.Backend.repository;

import com.MobileApp.Backend.model.Subscription;
import com.MobileApp.Backend.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Optional<Subscription> findByVendorId(Long vendorId);
    // Optional<Subscription> findByVendorId(Long vendorId);
    // Optional<Subscription> findByVendorId(Long vendorId);
    // Optional<Subscription> findByVendor(Vendor vendor);

    //  Optional<Subscription> findByVendor(Vendor vendor); // Fetch subscription by vendorId


}
