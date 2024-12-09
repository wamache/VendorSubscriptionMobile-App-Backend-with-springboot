package com.MobileApp.Backend.service;

import com.MobileApp.Backend.model.Payment;
import com.MobileApp.Backend.model.Vendor;
import com.MobileApp.Backend.repository.PaymentRepository;
import com.MobileApp.Backend.repository.VendorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final VendorRepository vendorRepository;
    private final MpesaService mpesaService;

    public PaymentService(PaymentRepository paymentRepository, VendorRepository vendorRepository, MpesaService mpesaService) {
        this.paymentRepository = paymentRepository;
        this.vendorRepository = vendorRepository;
        this.mpesaService = mpesaService;
    }

    @Transactional
    public Payment createPayment(Long vendorId, Double amount, String paymentMethod) {
        // Validate vendor
        Vendor vendor = vendorRepository.findById(Math.toIntExact(vendorId))
                .orElseThrow(() -> new IllegalArgumentException("Vendor not found with ID: " + vendorId));

        // Default to 'mpesa daraja' if paymentMethod is null or empty
        if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
            paymentMethod = "mpesa";
        }

        // If payment method is 'mpesa', initiate STK Push
        if ("mpesa".equalsIgnoreCase(paymentMethod)) {
            String phoneNumber = vendor.getPhoneNumber(); // Assuming Vendor has a phone number
            String accountReference = "0702385346";
//                    "Vendor_" + vendorId;
            String transactionDesc = "Payment for subscription";

            String stkResponse = mpesaService.initiateStkPush(phoneNumber, amount, accountReference, transactionDesc);
            System.out.println("STK Push Response: " + stkResponse);
        }

        // Create payment
        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setPaymentMethod(paymentMethod);
      // payment.setVendor(vendor);

        return paymentRepository.save(payment);
    }
}
