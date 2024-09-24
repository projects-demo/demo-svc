package com.example.demo_svc;

public class EnquiryResponse {
	private String message;
	private String enquiryDetailsUrl;

	public EnquiryResponse(String message, String enquiryDetailsUrl) {
		this.message = message;
		this.enquiryDetailsUrl = enquiryDetailsUrl;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEnquiryDetailsUrl() {
		return enquiryDetailsUrl;
	}

	public void setEnquiryDetailsUrl(String enquiryDetailsUrl) {
		this.enquiryDetailsUrl = enquiryDetailsUrl;
	}
}
