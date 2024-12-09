package com.MobileApp.Backend.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//
//
//import com.MobileApp.Backend.DTO.SubscriptionRequest;
//import com.MobileApp.Backend.DTO.SubscriptionResponse;
//import com.MobileApp.Backend.DTO.VendorResponse;
//import com.MobileApp.Backend.model.Subscription;
//import com.MobileApp.Backend.service.SubscriptionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/auth/subscriptions")
//public class SubscriptionsController {
//
//
//        private final SubscriptionService subscriptionService;
//
//    public SubscriptionsController(SubscriptionService subscriptionService) {
//        this.subscriptionService = subscriptionService;
//    }
//
//
//    @PostMapping
//        public ResponseEntity<SubscriptionResponse> createSubscription(@RequestBody SubscriptionRequest request) {
//            Subscription subscription = subscriptionService.addSubscription(
//                    request.getPlan(),
//                    request.getVendorId()
//            );
//
//            // Map entity to DTO
//            SubscriptionResponse response = new SubscriptionResponse(
//                    subscription.getSubscriptionId(),
//                    subscription.getCreatedAt(),
//                    subscription.getMaxProducts(),
//                    subscription.getPlan(),
//                    subscription.getPrice()
////                    new VendorResponse(
////                            subscription.getVendor().getVendorId(),
////                            subscription.getVendor().getName(),
////                            subscription.getVendor().getEmail(),
////                            subscription.getVendor().getPhoneNumber(),
////                            subscription.getVendor().getPasswordHash(),
////                            subscription.getVendor().getCreatedAt()
////                    )
//            );
//
//            return ResponseEntity.ok(response);
//        }
//    }
//
//
//

import com.MobileApp.Backend.DTO.SubscriptionRequestDTO;
import com.MobileApp.Backend.DTO.SubscriptionResponseDTO;
import com.MobileApp.Backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/subscriptions")
public class SubscriptionsController {

        @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping
    public List<SubscriptionResponseDTO> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionResponseDTO> getSubscriptionById(@PathVariable int id) {
        return ResponseEntity.of(subscriptionService.getSubscriptionById(id));
    }

    @PostMapping
    public SubscriptionResponseDTO createSubscription(@RequestBody SubscriptionRequestDTO subscriptionRequestDTO) {
        return subscriptionService.createSubscription(subscriptionRequestDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionResponseDTO> updateSubscription(@PathVariable int id, @RequestBody SubscriptionRequestDTO subscriptionRequestDTO) {
        return ResponseEntity.of(subscriptionService.updateSubscription(id, subscriptionRequestDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteSubscription(@PathVariable int id) {
        subscriptionService.deleteSubscription(id);
    }
}
