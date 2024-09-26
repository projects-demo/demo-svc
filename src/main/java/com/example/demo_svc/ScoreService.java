package com.example.demo_svc;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ScoreService {
	
	@Autowired
	private EconomicFactorRepository economicFactorRepository;

	private static String scoreUrl = "http://044e0a59-425b-44a1-b613-20e7e5aa4823.eastus2.azurecontainer.io/score";

	public String callScoreEndpoint(Enquiry newEnquiry) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");

		LocalDate expectedPurchaseDate = newEnquiry.getExpectedPurchaseDate();

		List<EconomicFactors> economicFactors = economicFactorRepository
				.findByMonthAndYear(expectedPurchaseDate.getMonthValue(), expectedPurchaseDate.getYear());
		double interestRate = 0, unemploymentRate = 0;
		int availableFinanceOptions = 0;

		if (!economicFactors.isEmpty()) {
			interestRate = economicFactors.get(0).getInterestRate();
			unemploymentRate = economicFactors.get(0).getUnemploymentRate();
			availableFinanceOptions = economicFactors.get(0).getAvailableFinanceOptions();
		}

		ScoreRequest scoreRequest = new ScoreRequest();
		Inputs inputs = new Inputs();
		ScoreData scoreData = new ScoreData();

		scoreData.setExpectedPurchaseDate(expectedPurchaseDate.toString());
		scoreData.setCarModel(newEnquiry.getCarModel());
		scoreData.setCustomerAge(newEnquiry.getCustomerAge());
		scoreData.setLocation(newEnquiry.getLocation());
		scoreData.setInquirySource(newEnquiry.getInquirySource());
		scoreData.setCustomerEnquiries(newEnquiry.getCustomerEnquiry());
		scoreData.setSalesExecutiveRemarks(newEnquiry.getSalesExecutiveRemarks());
		scoreData.setPurchaseMode(newEnquiry.getPurchaseMode());
		scoreData.setInquiryFrequency(newEnquiry.getCustomerEnquiryFrequency());

		scoreData.setInterestRate(interestRate);
		scoreData.setUnemploymentRate(unemploymentRate);
		scoreData.setAvailableFinanceOptions(availableFinanceOptions);

		inputs.setData(Collections.singletonList(scoreData));
		scoreRequest.setInputs(inputs);

		GlobalParameters globalParameters = new GlobalParameters();
		globalParameters.setMethod("predict");
		scoreRequest.setGlobalParameters(globalParameters);

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonRequest = null;
		try {
			jsonRequest = objectMapper.writeValueAsString(scoreRequest);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "Error creating JSON request";
		}

		System.out.println("Request JSON: " + jsonRequest);

		HttpEntity<ScoreRequest> requestEntity = new HttpEntity<>(scoreRequest, headers);

		ResponseEntity<ScoreResponse> responseEntity = restTemplate.exchange(scoreUrl, HttpMethod.POST, requestEntity,
				ScoreResponse.class);

		if (responseEntity.getStatusCode().is2xxSuccessful()) {
			List<String> results = responseEntity.getBody().getResults();
			if (results != null && !results.isEmpty()) {
				return results.get(0);
			} else {
				return "No results found";
			}
		} else {
			return "Prediction failed with status: " + responseEntity.getStatusCode();
		}
	}

}
