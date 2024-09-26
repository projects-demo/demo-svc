package com.example.demo_svc;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoreRequest {
    @JsonProperty("Inputs")
    private Inputs inputs;
    
    public Inputs getInputs() {
		return inputs;
	}

	public void setInputs(Inputs inputs) {
		this.inputs = inputs;
	}

	public GlobalParameters getGlobalParameters() {
		return globalParameters;
	}

	public void setGlobalParameters(GlobalParameters globalParameters) {
		this.globalParameters = globalParameters;
	}

	@JsonProperty("GlobalParameters")
    private GlobalParameters globalParameters;

    // Getters and Setters
}

 class Inputs {
    @JsonProperty("data")
    private List<ScoreData> data;

	public List<ScoreData> getData() {
		return data;
	}

	public void setData(List<ScoreData> data) {
		this.data = data;
	}

    // Getters and Setters
}

 class ScoreData {
    @JsonProperty("expected_purchase_date")
    private String expectedPurchaseDate;

    @JsonProperty("car_model")
    private String carModel;

    @JsonProperty("customer_age")
    private int customerAge;

    @JsonProperty("location")
    private String location;

    @JsonProperty("inquiry_source")
    private String inquirySource;

    @JsonProperty("customer_enquiries")
    private String customerEnquiries;

    @JsonProperty("sales_executive_remarks")
    private String salesExecutiveRemarks;

    @JsonProperty("purchase_mode")
    private String purchaseMode;

    @JsonProperty("interest_rate")
    private double interestRate;

    public String getExpectedPurchaseDate() {
		return expectedPurchaseDate;
	}

	public void setExpectedPurchaseDate(String expectedPurchaseDate) {
		this.expectedPurchaseDate = expectedPurchaseDate;
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

	public String getCustomerEnquiries() {
		return customerEnquiries;
	}

	public void setCustomerEnquiries(String customerEnquiries) {
		this.customerEnquiries = customerEnquiries;
	}

	public String getSalesExecutiveRemarks() {
		return salesExecutiveRemarks;
	}

	public void setSalesExecutiveRemarks(String salesExecutiveRemarks) {
		this.salesExecutiveRemarks = salesExecutiveRemarks;
	}

	public String getPurchaseMode() {
		return purchaseMode;
	}

	public void setPurchaseMode(String purchaseMode) {
		this.purchaseMode = purchaseMode;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getUnemploymentRate() {
		return unemploymentRate;
	}

	public void setUnemploymentRate(double unemploymentRate) {
		this.unemploymentRate = unemploymentRate;
	}

	public int getAvailableFinanceOptions() {
		return availableFinanceOptions;
	}

	public void setAvailableFinanceOptions(int availableFinanceOptions) {
		this.availableFinanceOptions = availableFinanceOptions;
	}

	public int getInquiryFrequency() {
		return inquiryFrequency;
	}

	public void setInquiryFrequency(int inquiryFrequency) {
		this.inquiryFrequency = inquiryFrequency;
	}

	@JsonProperty("unemployment_rate")
    private double unemploymentRate;

    @JsonProperty("available_finance_options")
    private int availableFinanceOptions;

    @JsonProperty("inquiry_frequency")
    private int inquiryFrequency;

    // Getters and Setters
}

 class GlobalParameters {
    @JsonProperty("method")
    private String method;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

    // Getters and Setters
}
