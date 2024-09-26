package com.example.demo_svc;

import javax.persistence.*;

@Entity
@IdClass(EconomicFactorsId.class) // Use composite key
public class EconomicFactors {
    
    @Id
    private int month; // Assuming it's an integer (1-12)

    @Id
    private int year;  // Assuming it's a four-digit integer

    private double interestRate;

    private double unemploymentRate;

    private int availableFinanceOptions;

    // Getters and setters

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
}
