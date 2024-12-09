package com.MobileApp.Backend.service;

import com.MobileApp.Backend.model.Business;
import com.MobileApp.Backend.repository.BusinessRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MobileApp.Backend.model.Branch;
import com.MobileApp.Backend.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchService {

    private final BranchRepository branchRepository;
    private final BusinessRepository businessRepository;

    public BranchService(BranchRepository branchRepository, BusinessRepository businessRepository) {
        this.branchRepository = branchRepository;
        this.businessRepository = businessRepository;
    }

    @Transactional
    public Branch addBranch(String address, String contactInfo, String name, Long businessId) {
        Business business = businessRepository.findById(businessId)
                .orElseThrow(() -> new IllegalArgumentException("Business not found with ID: " + businessId));

        Branch branch = new Branch();
        branch.setAddress(address);
        branch.setContactInfo(contactInfo);
        branch.setCreatedAt(LocalDateTime.now());
        branch.setName(name);
        branch.setBusiness(business);

        return branchRepository.save(branch);
    }

}
