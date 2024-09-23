package com.example.demo_svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/enquiries")
public class EnquiryController {

    @Autowired
    private EnquiryRepository enquiryRepository;

    @PostMapping
    public Enquiry createEnquiry(@RequestBody EnquiryRequest enquiryRequest) {
        Enquiry newEnquiry = new Enquiry();
        // Generate enquiry_id and inquiry_date
        newEnquiry.setEnquiryId(UUID.randomUUID().toString());
        newEnquiry.setInquiryDate(LocalDateTime.now());

        // Set other enquiry details from request
        newEnquiry.setCarModel(enquiryRequest.getCarModel());
        newEnquiry.setCustomerAge(enquiryRequest.getCustomerAge());
        newEnquiry.setCustomerName(enquiryRequest.getCustomerName());
        newEnquiry.setLocation(enquiryRequest.getLocation());
        newEnquiry.setInquirySource(enquiryRequest.getInquirySource());
        newEnquiry.setAvailableFinanceOptions(enquiryRequest.getAvailableFinanceOptions());
        newEnquiry.setContactNo(enquiryRequest.getContactNo());
        newEnquiry.setCustomerFeedback(enquiryRequest.getCustomerFeedback());
        newEnquiry.setSalesExecutiveRemarks(enquiryRequest.getSalesExecutiveRemarks());

        // Save the enquiry to the database
        return enquiryRepository.save(newEnquiry);
    }

    @GetMapping
    public Enquiry getEnquiry(
            @RequestParam(required = false) String enquiryId,
            @RequestParam(required = false) Long contactNo,
            @RequestParam(required = false) String customerName) {
        
        Enquiry enquiry = null;

        if (enquiryId != null) {
            enquiry = enquiryRepository.findById(enquiryId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Enquiry not found: "+enquiryId));
        } else if (contactNo != null) {
            enquiry = enquiryRepository.findByContactNo(contactNo)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Enquiry not found: "+contactNo));
        } else if (customerName != null) {
            enquiry = enquiryRepository.findByCustomerName(customerName)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Enquiry not found: "+customerName));
        }

        // If no enquiry found, an exception would have been thrown
        return enquiry;
    }
}
