package com.example.demo_svc;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CustomerEnquiry")
public class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "enquiryId")
    private String enquiryId;

    @Column(name = "inquiryDate")
    private LocalDateTime inquiryDate;

    @Column(name = "carModel")
    private String carModel;

    @Column(name = "customerAge")
    private Integer customerAge;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "location")
    private String location;

    @Column(name = "inquirySource")
    private String inquirySource;

    @Column(name = "availableFinanceOptions")
    private Integer availableFinanceOptions;

    @Column(name = "contactNo")
    private Long contactNo;

    @Column(name = "customerFeedback")
    private String customerFeedback;

    @Column(name = "salesExecutiveRemarks")
    private String salesExecutiveRemarks;
    
    @Column(name = "manualScore")
    private String manualScore;  
    
    @Column(name = "predictedScore")
    private String predictedScore;  
    
    

    public String getPredictedScore() {
		return predictedScore;
	}

	public void setPredictedScore(String predictedScore) {
		this.predictedScore = predictedScore;
	}

	public String getManualScore() {
        return manualScore;
    }

    public void setManualScore(String manualScore) {
        this.manualScore = manualScore;
    }
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(String customerId) {
		this.enquiryId = customerId;
	}

	public LocalDateTime getInquiryDate() {
		return inquiryDate;
	}

	public void setInquiryDate(LocalDateTime inquiryDate) {
		this.inquiryDate = inquiryDate;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public Integer getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getInquirySource() {
		return inquirySource;
	}

	public void setInquirySource(String inquirySource) {
		this.inquirySource = inquirySource;
	}

	public Integer getAvailableFinanceOptions() {
		return availableFinanceOptions;
	}

	public void setAvailableFinanceOptions(Integer availableFinanceOptions) {
		this.availableFinanceOptions = availableFinanceOptions;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getCustomerFeedback() {
		return customerFeedback;
	}

	public void setCustomerFeedback(String customerFeedback) {
		this.customerFeedback = customerFeedback;
	}

	public String getSalesExecutiveRemarks() {
		return salesExecutiveRemarks;
	}

	public void setSalesExecutiveRemarks(String salesExecutiveRemarks) {
		this.salesExecutiveRemarks = salesExecutiveRemarks;
	}


}
