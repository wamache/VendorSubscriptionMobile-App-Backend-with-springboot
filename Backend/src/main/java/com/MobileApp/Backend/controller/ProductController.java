package com.MobileApp.Backend.controller;

import com.MobileApp.Backend.DTO.ProductRequestDTO;
import com.MobileApp.Backend.DTO.ProductResponseDTO;
import com.MobileApp.Backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Endpoint to add a product
    @PostMapping("/add")
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestParam Long vendorId, @RequestBody ProductRequestDTO productDTO) {
        ProductResponseDTO response = productService.addProduct(vendorId, productDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

