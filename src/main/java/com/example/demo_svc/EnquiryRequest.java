package com.example.demo_svc;

import java.time.LocalDate;

public class EnquiryRequest {
	private String carModel;
	private int customerAge;
	private String customerName;
	private String location;
	private String inquirySource;
	private long contactNo;
	private String customerEnquiry;
	private Integer customerEnquiryFrequency;

	public Integer getCustomerEnquiryFrequency() {
		return customerEnquiryFrequency;
	}

	public void setCustomerEnquiryFrequency(Integer customerEnquiryFrequency) {
		this.customerEnquiryFrequency = customerEnquiryFrequency;
	}

	private String salesExecutiveRemarks;
	private String manualScore;
	private LocalDate expectedPurchaseDate;
	private String purchaseMode;

	public LocalDate getExpectedPurchaseDate() {
		return expectedPurchaseDate;
	}

	public void setExpectedPurchaseDate(LocalDate expectedPurchaseDate) {
		this.expectedPurchaseDate = expectedPurchaseDate;
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

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
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

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getCustomerEnquiry() {
		return customerEnquiry;
	}

	public void setCustomerEnquiry(String customerEnquiry) {
		this.customerEnquiry = customerEnquiry;
	}

	public String getSalesExecutiveRemarks() {
		return salesExecutiveRemarks;
	}

	public void setSalesExecutiveRemarks(String salesExecutiveRemarks) {
		this.salesExecutiveRemarks = salesExecutiveRemarks;
	}

}
