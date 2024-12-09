package com.MobileApp.Backend.controller;
import com.MobileApp.Backend.DTO.BranchRequest;
import com.MobileApp.Backend.DTO.BranchResponse;
import com.MobileApp.Backend.DTO.BusinessResponse;
import com.MobileApp.Backend.model.Branch;
import com.MobileApp.Backend.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/branches")
public class BranchesController {
    private final BranchService branchService;


    public BranchesController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping
    public ResponseEntity<BranchResponse> createBranch(@RequestBody BranchRequest request) {
        Branch branch = branchService.addBranch(
                request.getAddress(),
                request.getContactInfo(),
                request.getName(),
                request.getBusinessId()
        );

        // Map entity to DTO
        BranchResponse response = new BranchResponse(
                branch.getBranchId(),
                branch.getAddress(),
                branch.getContactInfo(),
                branch.getCreatedAt(),
                branch.getName(),
                new BusinessResponse(
                        branch.getBusiness().getBusinessId(),
                        branch.getBusiness().getAddress(),
                        branch.getBusiness().getContactInfo(),
                        branch.getBusiness().getCreatedAt(),
                        branch.getBusiness().getName(),
                        branch.getBusiness().getVendor().getVendorId()
                )
        );

        return ResponseEntity.ok(response);
    }
}
