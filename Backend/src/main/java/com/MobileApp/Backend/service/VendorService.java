package com.MobileApp.Backend.service;


import com.MobileApp.Backend.DTO.VendorRequestDTO;
import com.MobileApp.Backend.DTO.VendorResponse;
import com.MobileApp.Backend.model.Vendor;
import com.MobileApp.Backend.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    public List<VendorResponse> getAllVendors() {
//        return vendorRepository.findAll().stream()
//                .map(this::toVendorResponse)
//                .collect(Collectors.toList());
//    }
//
//    public Optional<VendorResponse> getVendorById(int id) {
//        return vendorRepository.findById(id).map(this::toVendorResponse);
//    }

    public VendorResponse createVendor(VendorRequestDTO vendorRequestDTO) {
        Vendor vendor = new Vendor();
        vendor.setName(vendorRequestDTO.getName());
        vendor.setEmail(vendorRequestDTO.getEmail());
        vendor.setPhoneNumber(vendorRequestDTO.getPhoneNumber());
        vendor.setPasswordHash(passwordEncoder.encode(vendorRequestDTO.getPassword()));
        Vendor savedVendor = vendorRepository.save(vendor);
        return toVendorResponseDTO(savedVendor);
    }

    public Optional<VendorResponse> updateVendor(int id, VendorRequestDTO vendorRequestDTO) {
        return vendorRepository.findById(id).map(existingVendor -> {
            existingVendor.setName(vendorRequestDTO.getName());
            existingVendor.setEmail(vendorRequestDTO.getEmail());
            existingVendor.setPhoneNumber(vendorRequestDTO.getPhoneNumber());
            existingVendor.setPasswordHash(passwordEncoder.encode(vendorRequestDTO.getPassword()));
            Vendor updatedVendor = vendorRepository.save(existingVendor);
            return toVendorResponseDTO(updatedVendor);
        });
    }

    public void deleteVendor(int id) {
        vendorRepository.deleteById(id);
    }

    private VendorResponse toVendorResponseDTO(Vendor vendor) {
        return new VendorResponse(
//                vendor.getVendorID(),
                vendor.getName(),
                vendor.getEmail(),
                vendor.getPhoneNumber(),
                vendor.getCreatedAt()
        );
    }



    public BCryptPasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

}
