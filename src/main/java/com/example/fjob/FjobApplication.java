package com.example.fjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FjobApplication {

	public static void main(String[] args) {
		SpringApplication.run(FjobApplication.class, args);
	}

}
