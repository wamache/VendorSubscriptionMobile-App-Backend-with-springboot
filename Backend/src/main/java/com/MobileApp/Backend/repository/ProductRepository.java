package com.MobileApp.Backend.repository;


import com.MobileApp.Backend.model.Product;
import com.MobileApp.Backend.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    int countByBusinessVendor(Vendor vendor);
//    int countByBusinessVendorId(Long vendorId);
//      int countByBusiness_VendorId(Long vendorId);  // Adjust this based on your actual mapping

//    int countByBusinessVendorId(Long vendorId);

//    int countByBusiness_Vendor_Id(Long vendorId);


//    @Query("SELECT COUNT(p) FROM Product p WHERE p.business.vendorId = :vendorId")
//    int countByBusinessVendorId(@Param("vendorId") Long vendorId);

}
