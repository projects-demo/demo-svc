package com.example.demo_svc;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface EnquiryRepository extends JpaRepository<Enquiry, String> {

    Optional<Enquiry> findByContactNo(Long contactNo);

    Optional<Enquiry> findByCustomerName(String customerName);
}
