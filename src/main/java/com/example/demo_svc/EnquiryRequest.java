package com.example.demo_svc;

public class EnquiryRequest {
    private String carModel;
    private int customerAge;
    private String customerName;
    private String location;
    private String inquirySource;
    private int availableFinanceOptions;
    private long contactNo;
    private String customerFeedback;
    private String salesExecutiveRemarks;
	private String manualScore;

	

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
	public int getAvailableFinanceOptions() {
		return availableFinanceOptions;
	}
	public void setAvailableFinanceOptions(int availableFinanceOptions) {
		this.availableFinanceOptions = availableFinanceOptions;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
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
