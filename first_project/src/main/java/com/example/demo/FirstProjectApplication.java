package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ioc=SpringApplication.run(FirstProjectApplication.class, args);
		

		//System.out.println(ioc.getBean("doctor",Doctor.class));
		
		Doctor ram =ioc.getBean("ram",Doctor.class);
		
		Doctor shyam =ioc.getBean("shyam",Doctor.class);
		
		DoctorApplication app = ioc.getBean(DoctorApplication.class);
		
		
		app.addDoctor(ram);
		app.addDoctor(shyam);
		
		app.getDoctors().forEach(System.out::println);
		
		
		
		
	}
	
	@Bean
	Doctor ram() throws Exception {
		
		return new Doctor("Ramesh", 993939, "ENT");
	}

	@Bean
	Doctor shyam() throws Exception {
		
		return new Doctor("Shyam", 8993939, "Dentist");
	}
}
