package com.example.demo_svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)

public class DemoSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSvcApplication.class, args);
	}

}
