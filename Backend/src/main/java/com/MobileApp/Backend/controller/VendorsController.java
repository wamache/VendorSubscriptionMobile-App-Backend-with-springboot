package com.MobileApp.Backend.controller;


import com.MobileApp.Backend.DTO.VendorRequestDTO;
import com.MobileApp.Backend.DTO.VendorResponse;
import com.MobileApp.Backend.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/vendors")
public class VendorsController {

    @Autowired
    private VendorService vendorService;



    @PostMapping
    public VendorResponse createVendor(@RequestBody VendorRequestDTO vendorRequestDTO) {
        return vendorService.createVendor(vendorRequestDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendorResponse> updateVendor(@PathVariable int id, @RequestBody VendorRequestDTO vendorRequestDTO) {
        return ResponseEntity.of(vendorService.updateVendor(id, vendorRequestDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteVendor(@PathVariable int id) {
        vendorService.deleteVendor(id);
    }
}
