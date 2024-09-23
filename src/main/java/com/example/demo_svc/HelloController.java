package com.example.demo_svc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


	@GetMapping("/health")
	public String enquiry() {
		return "contoso svc is up and running!";
	}
	
}