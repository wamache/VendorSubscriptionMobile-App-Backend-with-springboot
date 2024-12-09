package com.MobileApp.Backend.repository;

import com.MobileApp.Backend.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {}