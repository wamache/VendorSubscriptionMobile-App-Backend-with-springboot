package com.MobileApp.Backend.controller;

import com.MobileApp.Backend.DTO.BusinessRequest;
import com.MobileApp.Backend.model.Business;
import com.MobileApp.Backend.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/businesses")
public class BusinessesController {


    private final BusinessService businessService;


    public BusinessesController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @PostMapping
    public ResponseEntity<Business> createBusiness(@RequestBody BusinessRequest request) {
        Business business = businessService.addBusiness(
                request.getAddress(),
                request.getContactInfo(),
                request.getName(),
                request.getVendorId()
        );

        return ResponseEntity.ok(business);
    }
//
}
