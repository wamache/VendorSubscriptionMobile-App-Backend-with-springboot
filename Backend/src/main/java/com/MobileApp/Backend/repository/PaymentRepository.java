package com.MobileApp.Backend.repository;

import com.MobileApp.Backend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {}