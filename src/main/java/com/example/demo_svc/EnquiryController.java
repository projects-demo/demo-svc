package com.example.demo_svc;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

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


@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

    @Autowired
    private EnquiryRepository enquiryRepository;
    
    @Autowired
    private ScoreService scoreService;
    
    @PostMapping("/create")
    public EnquiryResponse createEnquiry(@RequestBody EnquiryRequest enquiryRequest, HttpServletRequest request) {
        Enquiry newEnquiry = new Enquiry();
        
        String enquiryId = UUID.randomUUID().toString();
        newEnquiry.setEnquiryId(enquiryId);
        newEnquiry.setInquiryDate(LocalDate.now());

        newEnquiry.setExpectedPurchaseDate(enquiryRequest.getExpectedPurchaseDate());
        newEnquiry.setPurchaseMode(enquiryRequest.getPurchaseMode());
        newEnquiry.setCarModel(enquiryRequest.getCarModel());
        newEnquiry.setCustomerAge(enquiryRequest.getCustomerAge());
        newEnquiry.setCustomerName(enquiryRequest.getCustomerName());
        newEnquiry.setLocation(enquiryRequest.getLocation());
        newEnquiry.setInquirySource(enquiryRequest.getInquirySource());
        newEnquiry.setContactNo(enquiryRequest.getContactNo());
        newEnquiry.setCustomerFeedback(enquiryRequest.getCustomerEnquiry());
        newEnquiry.setSalesExecutiveRemarks(enquiryRequest.getSalesExecutiveRemarks());
        newEnquiry.setManualScore(enquiryRequest.getManualScore());
        newEnquiry.setCustomerEnquiryFrequency(enquiryRequest.getCustomerEnquiryFrequency());

        enquiryRepository.save(newEnquiry);

        String predictedScore = scoreService.callScoreEndpoint(newEnquiry);
        
        System.err.println("predictedScore---" + predictedScore);

        String enquiryDetailsUrl = getBaseUrl(request) + "/enquiry/details?enquiryId=" + enquiryId;

        return new EnquiryResponse("Enquiry created successfully", enquiryDetailsUrl, predictedScore);
    }

    @GetMapping("/details")
    public EnquiryResponseDetails getEnquiryById(@RequestParam String enquiryId) {
        Enquiry enquiry = enquiryRepository.findByEnquiryId(enquiryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Enquiry not found: " + enquiryId));

        String predictedScore = scoreService.callScoreEndpoint(enquiry);

        return new EnquiryResponseDetails(enquiry, predictedScore);
    }  

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
    public EnquiryResponseDetails updateEnquiry(@RequestParam String enquiryId, 
                                         @RequestBody UpdateEnquiryRequest updateEnquiryRequest, HttpServletRequest request) {
        Enquiry existingEnquiry = enquiryRepository.findByEnquiryId(enquiryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Enquiry not found: " + enquiryId));

        if (updateEnquiryRequest.getSalesExecutiveRemarks() != null) {
            String updatedRemarks = existingEnquiry.getSalesExecutiveRemarks() != null
                    ? existingEnquiry.getSalesExecutiveRemarks() + "\n" + updateEnquiryRequest.getSalesExecutiveRemarks()
                    : updateEnquiryRequest.getSalesExecutiveRemarks();
            existingEnquiry.setSalesExecutiveRemarks(updatedRemarks);
        }

        if (updateEnquiryRequest.getCustomerFeedback() != null) {
            String updatedFeedback = existingEnquiry.getCustomerFeedback() != null
                    ? existingEnquiry.getCustomerFeedback() + "\n" + updateEnquiryRequest.getCustomerFeedback()
                    : updateEnquiryRequest.getCustomerFeedback();
            existingEnquiry.setCustomerFeedback(updatedFeedback);
        }

        if (updateEnquiryRequest.getManualScore() != null) {
            existingEnquiry.setManualScore(updateEnquiryRequest.getManualScore());
        }

        enquiryRepository.save(existingEnquiry);
        
        return getEnquiryById(enquiryId);       
    }
    
    private String getBaseUrl(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
    }
    
}
