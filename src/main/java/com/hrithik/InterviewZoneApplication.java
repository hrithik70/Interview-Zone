package com.hrithik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(value = "http://localhost:8080")
@SpringBootApplication
public class InterviewZoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewZoneApplication.class, args);
	}

}
