package com.example.demo_svc;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

    @Autowired
    private EnquiryRepository enquiryRepository;

    @PostMapping("/create")
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

    @GetMapping("/{enquiryId}/details")
    public Enquiry getEnquiryById(@PathVariable String enquiryId) {
        return enquiryRepository.findByEnquiryId(enquiryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Enquiry not found: " + enquiryId));
    }
    

 // Search for enquiries by contact number or customer name
    @GetMapping("/search")
    public List<Enquiry> searchEnquiries(
            @RequestParam(required = false) Long contactNo,
            @RequestParam(required = false) String customerName) {

        List<Enquiry> enquiries = null;

        if (contactNo != null) {
            enquiries = enquiryRepository.findAllByContactNo(contactNo);
        } else if (customerName != null) {
            enquiries = enquiryRepository.findAllByCustomerName(customerName);
        }

        if (enquiries == null || enquiries.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Enquiries not found");
        }

        return enquiries;
    }

}
