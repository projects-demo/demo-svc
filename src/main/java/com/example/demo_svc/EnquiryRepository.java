package com.example.demo_svc;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {

    Optional<Enquiry> findByEnquiryId(String enquiryId);

    List<Enquiry> findAllByContactNo(Long contactNo);

    List<Enquiry> findAllByCustomerName(String customerName);
}
