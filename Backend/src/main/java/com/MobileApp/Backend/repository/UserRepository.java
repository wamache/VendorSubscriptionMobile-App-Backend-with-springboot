package com.MobileApp.Backend.repository;

import com.MobileApp.Backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users, Integer> {}
