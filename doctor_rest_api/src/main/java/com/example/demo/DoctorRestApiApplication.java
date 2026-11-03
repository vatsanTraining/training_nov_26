package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DoctorRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorRestApiApplication.class, args);
	}

	@Bean
	Doctor ram() throws Exception {
		
		return new Doctor("Ramesh", 993939, "ENT");
	}

	@Bean
	Doctor shyam() throws Exception {
		
		return new Doctor("Shyam", 8993939, "Dentist");
	}
	
	@Bean
	Doctor shiv() throws Exception {
		
		return new Doctor("Shiv", 555232, "ENT");
	}

	@Bean
	Doctor magesh() throws Exception {
		
		return new Doctor("Magesh", 65432, "Derm");
	}
}
