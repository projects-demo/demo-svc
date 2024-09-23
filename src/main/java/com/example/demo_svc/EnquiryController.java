package com.example.demo_svc;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/enquiries")
public class EnquiryController {

    @PostMapping
    public Enquiry createEnquiry(@RequestBody EnquiryRequest enquiryRequest) {
        Enquiry newEnquiry = new Enquiry();
        // Generate customer_id and inquiry_date
        newEnquiry.setCustomerId("CUST_" + UUID.randomUUID().toString());
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

        // Save the enquiry to the database (you can add repository logic here)
        
        return newEnquiry; // Return the created enquiry object
    }
    
    
    @GetMapping("/{id}")
    public Enquiry getEnquiry(@PathVariable String id) {
        // Retrieve the enquiry by id (this is just a mock response)
        Enquiry enquiry = new Enquiry();
        enquiry.setCustomerId(id);
        enquiry.setInquiryDate(LocalDateTime.now());  // Just for example, you'd retrieve from the DB
        enquiry.setCarModel("Hyundai");
        enquiry.setCustomerAge(30);
        enquiry.setCustomerName("Kanika");
        enquiry.setLocation("Central");
        enquiry.setInquirySource("dealer");
        enquiry.setAvailableFinanceOptions(2);
        enquiry.setContactNo(1234567890L);
        enquiry.setCustomerFeedback("I like your car, will purchase next month");
        enquiry.setSalesExecutiveRemarks("Good customer, follow up next month");

        return enquiry;
    }
}
