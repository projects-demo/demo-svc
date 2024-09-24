package com.example.demo_svc;

public class UpdateEnquiryRequest {
    private String salesExecutiveRemarks;
    private String customerFeedback;
    private String manualScore;  

    public String getSalesExecutiveRemarks() {
        return salesExecutiveRemarks;
    }

    public void setSalesExecutiveRemarks(String salesExecutiveRemarks) {
        this.salesExecutiveRemarks = salesExecutiveRemarks;
    }

    public String getCustomerFeedback() {
        return customerFeedback;
    }

    public void setCustomerFeedback(String customerFeedback) {
        this.customerFeedback = customerFeedback;
    }

    public String getManualScore() {
        return manualScore;
    }

    public void setManualScore(String manualScore) {
        this.manualScore = manualScore;
    }
}
