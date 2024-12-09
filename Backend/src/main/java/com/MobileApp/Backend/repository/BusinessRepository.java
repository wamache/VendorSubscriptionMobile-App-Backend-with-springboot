package com.MobileApp.Backend.repository;

import com.MobileApp.Backend.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long> {
}
