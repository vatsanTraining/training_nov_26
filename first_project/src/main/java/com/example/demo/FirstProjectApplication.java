package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ioc=SpringApplication.run(FirstProjectApplication.class, args);
		

		System.out.println(ioc.getBean("doctor",Doctor.class));
		
		System.out.println(ioc.getBean("ram",Doctor.class));
		
		
		
		
	}
	
	@Bean
	Doctor ram() throws Exception {
		
		return new Doctor("Ramesh", 993939, "ENT");
	}

}
