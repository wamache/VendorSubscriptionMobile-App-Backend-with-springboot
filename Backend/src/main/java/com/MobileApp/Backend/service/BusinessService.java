package com.MobileApp.Backend.service;


import com.MobileApp.Backend.model.Business;
import com.MobileApp.Backend.model.Vendor;
import com.MobileApp.Backend.repository.BusinessRepository;
import com.MobileApp.Backend.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusinessService {

    private final BusinessRepository businessRepository;
    private final VendorRepository vendorRepository;

    public BusinessService(BusinessRepository businessRepository, VendorRepository vendorRepository) {
        this.businessRepository = businessRepository;
        this.vendorRepository = vendorRepository;
    }


    @Transactional
    public Business addBusiness(String address, String contactInfo, String name, Long vendorId) {
        Vendor vendor = vendorRepository.findById(Math.toIntExact(vendorId))
                .orElseThrow(() -> new IllegalArgumentException("Vendor not found with ID: " + vendorId));

        Business business = new Business();
        business.setAddress(address);
        business.setContactInfo(contactInfo);
        business.setCreatedAt(LocalDateTime.now());
        business.setName(name);
        business.setVendor(vendor);

        return businessRepository.save(business);
    }


}
