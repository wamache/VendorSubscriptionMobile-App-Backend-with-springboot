package com.MobileApp.Backend.controller;

import com.MobileApp.Backend.DTO.PaymentRequest;
import com.MobileApp.Backend.DTO.PaymentResponse;
import com.MobileApp.Backend.DTO.VendorResponse;
import com.MobileApp.Backend.model.Payment;
import com.MobileApp.Backend.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> createPayment(@RequestBody PaymentRequest request) {
        Payment payment = paymentService.createPayment(
                request.getVendorId(),
                request.getAmount(),
                request.getPaymentMethod()
        );

        // Map entity to DTO
        PaymentResponse response = new PaymentResponse(
                payment.getPaymentId(),
                payment.getAmount(),
                payment.getPaymentDate(),
                payment.getPaymentMethod(),
                new VendorResponse(
                        payment.getVendor().getVendorId(),
                        payment.getVendor().getName(),
                        payment.getVendor().getEmail(),
                        payment.getVendor().getPhoneNumber(),
                        payment.getVendor().getPasswordHash(),
                        payment.getVendor().getCreatedAt()
                )
        );

        return ResponseEntity.ok(response);
    }
}
