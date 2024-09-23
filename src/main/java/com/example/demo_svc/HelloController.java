package com.example.demo_svc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


	@GetMapping("/enquiry")
	public String enquiry() {
		return "enquiry!";
	}
	
}