package com.app.Trainbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.app.Trainbooking.entity")
public class Application2 {

	public static void main(String[] args) {
		SpringApplication.run(Application2.class, args);
	}

}
