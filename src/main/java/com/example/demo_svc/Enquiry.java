package com.example.demo_svc;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CustomerEnquiry")
public class Enquiry {

	@Id
	@Column(name = "inquiryId")
	private String enquiryId;

	@Column(name = "inquiryDate")
	private LocalDate inquiryDate;

	@Column(name = "expectedPurchaseDate")
	private LocalDate expectedPurchaseDate;

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

	@Column(name = "contactNo")
	private Long contactNo;

	@Column(name = "customerEnquiry")
	private String customerEnquiry;

	@Column(name = "customerEnquiryFrequency")
	private Integer customerEnquiryFrequency;

	@Column(name = "salesExecutiveRemarks")
	private String salesExecutiveRemarks;

	@Column(name = "manualScore")
	private String manualScore;

	@Column(name = "purchaseMode")
	private String purchaseMode;

	public String getCustomerEnquiry() {
		return customerEnquiry;
	}

	public void setCustomerEnquiry(String customerEnquiry) {
		this.customerEnquiry = customerEnquiry;
	}

	public String getPurchaseMode() {
		return purchaseMode;
	}

	public void setPurchaseMode(String purchaseMode) {
		this.purchaseMode = purchaseMode;
	}

	public String getManualScore() {
		return manualScore;
	}

	public void setManualScore(String manualScore) {
		this.manualScore = manualScore;
	}

	public String getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(String customerId) {
		this.enquiryId = customerId;
	}

	public LocalDate getInquiryDate() {
		return inquiryDate;
	}

	public void setInquiryDate(LocalDate inquiryDate) {
		this.inquiryDate = inquiryDate;
	}

	public LocalDate getExpectedPurchaseDate() {
		return expectedPurchaseDate;
	}

	public void setExpectedPurchaseDate(LocalDate expectedPurchaseDate) {
		this.expectedPurchaseDate = expectedPurchaseDate;
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

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getCustomerFeedback() {
		return customerEnquiry;
	}

	public void setCustomerFeedback(String customerEnquiry) {
		this.customerEnquiry = customerEnquiry;
	}

	public String getSalesExecutiveRemarks() {
		return salesExecutiveRemarks;
	}

	public void setSalesExecutiveRemarks(String salesExecutiveRemarks) {
		this.salesExecutiveRemarks = salesExecutiveRemarks;
	}

	public Integer getCustomerEnquiryFrequency() {
		return customerEnquiryFrequency;
	}

	public void setCustomerEnquiryFrequency(Integer customerEnquiryFrequency) {
		this.customerEnquiryFrequency = customerEnquiryFrequency;
	}



}
