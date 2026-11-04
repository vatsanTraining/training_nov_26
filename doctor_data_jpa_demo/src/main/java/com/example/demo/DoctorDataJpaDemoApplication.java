package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorInfoService;

@SpringBootApplication
public class DoctorDataJpaDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(DoctorDataJpaDemoApplication.class, args);
	
		
		DoctorInfoService service = ctx.getBean(DoctorInfoService.class);
		
		Doctor beanOne = ctx.getBean("ram",Doctor.class);
		
		Doctor beanTwo = ctx.getBean("shyam",Doctor.class);
		
		Doctor beanThree = ctx.getBean("shiv",Doctor.class);
		
		service.addDoctor(beanOne);
		
		service.addDoctor(beanTwo);
		
		service.addDoctor(beanThree);
		
	
		service.findAll().forEach(System.out::println);
		
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


}
