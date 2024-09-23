package com.example.demo_svc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	
	@GetMapping("/enquiry")
	public String enquiry() {
		return "enquiry!";
	}
	
}