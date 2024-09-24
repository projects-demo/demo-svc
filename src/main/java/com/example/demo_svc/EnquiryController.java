package com.example.demo_svc;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

    @Autowired
    private EnquiryRepository enquiryRepository;

    @PostMapping("/create")
    public EnquiryResponse createEnquiry(@RequestBody EnquiryRequest enquiryRequest, HttpServletRequest request) {
        Enquiry newEnquiry = new Enquiry();
        
        // Generate enquiry_id and inquiry_date
        String enquiryId = UUID.randomUUID().toString();
        newEnquiry.setEnquiryId(enquiryId);
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
        newEnquiry.setManualScore(enquiryRequest.getManualScore());


        // Save the enquiry to the database
        enquiryRepository.save(newEnquiry);

        // Construct the details URL using HttpServletRequest
        String enquiryDetailsUrl = getBaseUrl(request) + "/enquiry/details?enquiryId=" + enquiryId;
 
        // Return the custom response with the success message and the details URL
        return new EnquiryResponse("Enquiry created successfully", enquiryDetailsUrl);
    }
    
    @GetMapping("/details")
    public Enquiry getEnquiryById(@RequestParam String enquiryId) {
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

    
    @PutMapping("/update")
    public EnquiryResponse updateEnquiry(@RequestParam String enquiryId, 
                                         @RequestBody UpdateEnquiryRequest updateEnquiryRequest, HttpServletRequest request) {
        // Find the existing enquiry by enquiryId
        Enquiry existingEnquiry = enquiryRepository.findByEnquiryId(enquiryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Enquiry not found: " + enquiryId));

        // Append to Sales Executive Remarks if provided
        if (updateEnquiryRequest.getSalesExecutiveRemarks() != null) {
            String updatedRemarks = existingEnquiry.getSalesExecutiveRemarks() != null
                    ? existingEnquiry.getSalesExecutiveRemarks() + "\n" + updateEnquiryRequest.getSalesExecutiveRemarks()
                    : updateEnquiryRequest.getSalesExecutiveRemarks();
            existingEnquiry.setSalesExecutiveRemarks(updatedRemarks);
        }

        // Append to Customer Feedback if provided
        if (updateEnquiryRequest.getCustomerFeedback() != null) {
            String updatedFeedback = existingEnquiry.getCustomerFeedback() != null
                    ? existingEnquiry.getCustomerFeedback() + "\n" + updateEnquiryRequest.getCustomerFeedback()
                    : updateEnquiryRequest.getCustomerFeedback();
            existingEnquiry.setCustomerFeedback(updatedFeedback);
        }

        // Update the manualScore if provided (hot/warm/cold)
        if (updateEnquiryRequest.getManualScore() != null) {
            existingEnquiry.setManualScore(updateEnquiryRequest.getManualScore());
        }

        // Save the updated enquiry
        enquiryRepository.save(existingEnquiry);
        String enquiryDetailsUrl = getBaseUrl(request) + "/enquiry/details?enquiryId=" + enquiryId;

        return new EnquiryResponse("Enquiry updated successfully", enquiryDetailsUrl);
    }
    
    private String getBaseUrl(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
    }
    
}
