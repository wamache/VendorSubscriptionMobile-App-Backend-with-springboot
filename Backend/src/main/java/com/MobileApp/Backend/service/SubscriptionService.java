//package com.MobileApp.Backend.service;
////
////
////import com.MobileApp.Backend.model.Subscription;
////import com.MobileApp.Backend.model.Vendor;
////import com.MobileApp.Backend.repository.SubscriptionRepository;
////import com.MobileApp.Backend.repository.VendorRepository;
////import org.springframework.stereotype.Service;
////import org.springframework.transaction.annotation.Transactional;
////
////import java.time.LocalDateTime;
////
////@Service
////public class SubscriptionService {
////
////    private final SubscriptionRepository subscriptionRepository;
////    private final VendorRepository vendorRepository;
////
////    public SubscriptionService(SubscriptionRepository subscriptionRepository, VendorRepository vendorRepository) {
////        this.subscriptionRepository = subscriptionRepository;
////        this.vendorRepository = vendorRepository;
////    }
////
////    @Transactional
////    public Subscription createSubscription(Long vendorId, String plan, Integer maxProducts, int additionalBranches) {
////        // Validate vendor
////        Vendor vendor = vendorRepository.findById(Math.toIntExact(vendorId))
////                .orElseThrow(() -> new IllegalArgumentException("Vendor not found with ID: " + vendorId));
////
////        // Calculate plan price
////        double basePrice;
////        switch (plan.toLowerCase()) {
////            case "starter":
////                basePrice = 136.84;
////                break;
////            case "pro":
////                basePrice = 410.52;
////                break;
////            case "enterprise":
////                basePrice = 684.20;
////                break;
////            default:
////                throw new IllegalArgumentException("Invalid plan: " + plan);
////        }
////
////        // Additional branch charges
////        double additionalBranchPrice = additionalBranches * 136.84;
////
////        // Calculate total price
////        double totalPrice = basePrice + additionalBranchPrice;
////
////        // Create the subscription
////        Subscription subscription = new Subscription();
////        subscription.setCreatedAt(LocalDateTime.now());
////        subscription.setMaxProducts(maxProducts);
////        subscription.setPlan(plan);
////        subscription.setPrice(totalPrice);
////        subscription.setVendor(vendor);
////
////        return subscriptionRepository.save(subscription);
////    }
////}
//
////
////import com.MobileApp.Backend.model.Subscription;
////import com.MobileApp.Backend.model.Vendor;
////import com.MobileApp.Backend.repository.BranchRepository;
////import com.MobileApp.Backend.repository.SubscriptionRepository;
////import com.MobileApp.Backend.repository.VendorRepository;
////import org.springframework.stereotype.Service;
////import org.springframework.transaction.annotation.Transactional;
////
////import java.math.BigDecimal;
////import java.time.LocalDateTime;
////
////@Service
////public class SubscriptionService {
////
////    private final SubscriptionRepository subscriptionRepository;
////    private final VendorRepository vendorRepository;
////    private final BranchRepository branchRepository;
////
////    private static final double STARTER_PRICE = 136.84;
////    private static final double PRO_PRICE = 410.52;
////    private static final double ENTERPRISE_PRICE = 684.20;
////    private static final double ADDITIONAL_BRANCH_PRICE = 136.84;
////
////    public SubscriptionService(SubscriptionRepository subscriptionRepository, VendorRepository vendorRepository, BranchRepository branchRepository) {
////        this.subscriptionRepository = subscriptionRepository;
////        this.vendorRepository = vendorRepository;
////        this.branchRepository = branchRepository;
////    }
////
////    @Transactional
////    public Subscription addSubscription(String plan, Long vendorId) {
//////        Vendor vendor = vendorRepository.findById(Math.toIntExact(vendorId))
//////                .orElseThrow(() -> new IllegalArgumentException("Vendor not found with ID: " + vendorId));
//////        Long vendorId
////        // Calculate base price based on the plan
////        double basePrice;
////        int maxProducts;
////        switch (plan.toLowerCase()) {
////            case "starter":
////                basePrice = STARTER_PRICE;
////                maxProducts = 10;
////                break;
////            case "pro":
////                basePrice = PRO_PRICE;
////                maxProducts = 50;
////                break;
////            case "enterprise":
////                basePrice = ENTERPRISE_PRICE;
////                maxProducts = 100;
////                break;
////            default:
////                throw new IllegalArgumentException("Invalid plan: " + plan);
////        }
////
////        // Calculate additional charges for extra branches
////        Vendor vendor = new Vendor();
////        int branchCount = branchRepository.countByBusiness_VendorId(vendor.getVendorId());
////        double additionalBranchCharges = (branchCount - 1) * ADDITIONAL_BRANCH_PRICE; // First branch is included
////        double totalPrice = basePrice + Math.max(0, additionalBranchCharges);
////
////        Subscription subscription = new Subscription();
////        subscription.setCreatedAt(LocalDateTime.now());
////        subscription.setMaxProducts(maxProducts);
////        subscription.setPlan(plan);
////        subscription.setPrice(BigDecimal.valueOf(totalPrice));
////       subscription.setVendor(vendor.getVendorId());
////
////        return subscriptionRepository.save(subscription);
////    }
////}
////
////
//
//
//import com.MobileApp.Backend.DTO.SubscriptionRequestDTO;
//import com.MobileApp.Backend.DTO.SubscriptionResponseDTO;
//import com.MobileApp.Backend.model.Subscription;
//import com.MobileApp.Backend.repository.SubscriptionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class SubscriptionService {
//
//    @Autowired
//    private SubscriptionRepository subscriptionRepository;
//
//    public List<SubscriptionResponseDTO> getAllSubscriptions() {
//        return subscriptionRepository.findAll().stream()
//                .map(this::toSubscriptionResponseDTO)
//                .collect(Collectors.toList());
//    }
//
//    public Optional<SubscriptionResponseDTO> getSubscriptionById(int id) {
//        return subscriptionRepository.findById((long) id).map(this::toSubscriptionResponseDTO);
//    }
//
//    public SubscriptionResponseDTO createSubscription(SubscriptionRequestDTO subscriptionRequestDTO) {
//        Subscription subscription = new Subscription();
//        //Subscription subscription = new Subscription();
//        subscription.setCreatedAt(LocalDateTime.now()); // Set created date
//
//       // subscription.setVendor(subscriptionRequestDTO.getVendorId());
//        subscription.setPlan(subscriptionRequestDTO.getPlan());
//        subscription.setPrice(subscriptionRequestDTO.getPrice());
//        subscription.setMaxProducts(subscriptionRequestDTO.getMaxProducts());
//        Subscription savedSubscription = subscriptionRepository.save(subscription);
//        return toSubscriptionResponseDTO(savedSubscription);
//    }
//
//    public Optional<SubscriptionResponseDTO> updateSubscription(int id, SubscriptionRequestDTO subscriptionRequestDTO) {
//        return subscriptionRepository.findById((long) id).map(existingSubscription -> {
//            existingSubscription.setPlan(subscriptionRequestDTO.getPlan());
//            existingSubscription.setPrice(subscriptionRequestDTO.getPrice());
//            existingSubscription.setMaxProducts(subscriptionRequestDTO.getMaxProducts());
//            Subscription updatedSubscription = subscriptionRepository.save(existingSubscription);
//            return toSubscriptionResponseDTO(updatedSubscription);
//        });
//    }
//
//    public void deleteSubscription(int id) {
//        subscriptionRepository.deleteById((long) id);
//    }
//
//    private SubscriptionResponseDTO toSubscriptionResponseDTO(Subscription subscription) {
//        return new SubscriptionResponseDTO(
//                Math.toIntExact(subscription.getSubscriptionId()),
//                subscription.getPlan(),
//                subscription.getPrice(),
//                subscription.getMaxProducts(),
//                subscription.getCreatedAt()
//        );
//    }
//
//    public BigDecimal calculateSubscriptionFee(String plan, int branches) {
//        BigDecimal baseFee;
//        switch (plan.toLowerCase()) {
//            case "starter":
//                baseFee = new BigDecimal("136.84");
//                break;
//            case "pro":
//                baseFee = new BigDecimal("410.52");
//                break;
//            case "enterprise":
//                baseFee = new BigDecimal("684.20");
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid subscription plan");
//        }
//
//        // Additional fee for branches
//        BigDecimal branchFee = new BigDecimal("136.84").multiply(new BigDecimal(branches));
//        return baseFee.add(branchFee);
//    }
//
//}

package com.MobileApp.Backend.service;

import com.MobileApp.Backend.DTO.SubscriptionRequestDTO;
import com.MobileApp.Backend.DTO.SubscriptionResponseDTO;
import com.MobileApp.Backend.model.Subscription;
import com.MobileApp.Backend.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<SubscriptionResponseDTO> getAllSubscriptions() {
        return subscriptionRepository.findAll().stream()
                .map(this::toSubscriptionResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<SubscriptionResponseDTO> getSubscriptionById(int id) {
        return subscriptionRepository.findById((long) id).map(this::toSubscriptionResponseDTO);
    }

    public SubscriptionResponseDTO createSubscription(SubscriptionRequestDTO subscriptionRequestDTO) {
        Subscription subscription = new Subscription();
        String plan = subscriptionRequestDTO.getPlan();

        // Set subscription details based on the plan
        BigDecimal price;
        int maxProducts;
        switch (plan.toLowerCase()) {
            case "starter":
                price = new BigDecimal("136.84");
                maxProducts = 10;
                break;
            case "pro":
                price = new BigDecimal("410.52");
                maxProducts = 50;
                break;
            case "enterprise":
                price = new BigDecimal("684.20");
                maxProducts = 100;
                break;
            default:
                throw new IllegalArgumentException("Invalid subscription plan");
        }

        // Set values in the subscription object
        subscription.setPlan(plan);
        subscription.setPrice(price);
        subscription.setMaxProducts(maxProducts);
        subscription.setCreatedAt(LocalDateTime.now()); // Set created date

        Subscription savedSubscription = subscriptionRepository.save(subscription);
        return toSubscriptionResponseDTO(savedSubscription);
    }

    public Optional<SubscriptionResponseDTO> updateSubscription(int id, SubscriptionRequestDTO subscriptionRequestDTO) {
        return subscriptionRepository.findById((long) id).map(existingSubscription -> {
            String plan = subscriptionRequestDTO.getPlan();


            // Set subscription details based on the plan
            BigDecimal price;
            String maxProducts;
            switch (plan.toLowerCase()) {
                case "starter":
                    price = new BigDecimal("136.84");
                    maxProducts = "10";
                    break;
                case "pro":
                    price = new BigDecimal("410.52");
                    maxProducts = "50";
                    break;
                case "enterprise":
                    price = new BigDecimal("684.20");
                    maxProducts = "unlimited";
                    break;
                default:
                    throw new IllegalArgumentException("Invalid subscription plan");
            }

            // Set values in the subscription object
           // existingSubscription.setPlan(subscriptionRequestDTO.getPlan());
            existingSubscription.setPlan(plan);
            existingSubscription.setPrice(price);
            existingSubscription.setMaxProducts(Integer.valueOf(maxProducts));
            existingSubscription.setCreatedAt(LocalDateTime.now()); // Set created date

//            existingSubscription.setPlan(subscriptionRequestDTO.getPlan());
//            existingSubscription.setPrice(subscriptionRequestDTO.getPrice());
//            existingSubscription.setMaxProducts(subscriptionRequestDTO.getMaxProducts());
            Subscription updatedSubscription = subscriptionRepository.save(existingSubscription);
            return toSubscriptionResponseDTO(updatedSubscription);
        });
    }

    public void deleteSubscription(int id) {
        subscriptionRepository.deleteById((long) id);
    }

    private SubscriptionResponseDTO toSubscriptionResponseDTO(Subscription subscription) {
        return new SubscriptionResponseDTO(
                Math.toIntExact(subscription.getSubscriptionId()),
                subscription.getPlan(),
                subscription.getPrice(),
                subscription.getMaxProducts(),
                subscription.getCreatedAt()
        );
    }

    public BigDecimal calculateSubscriptionFee(String plan, int branches) {
        BigDecimal baseFee;
        switch (plan.toLowerCase()) {
            case "starter":
                baseFee = new BigDecimal("136.84");
                break;
            case "pro":
                baseFee = new BigDecimal("410.52");
                break;
            case "enterprise":
                baseFee = new BigDecimal("684.20");
                break;
            default:
                throw new IllegalArgumentException("Invalid subscription plan");
        }

        // Additional fee for branches
        BigDecimal branchFee = new BigDecimal("136.84").multiply(new BigDecimal(branches));
        return baseFee.add(branchFee);
    }
}
