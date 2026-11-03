package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/doctors")
public class DoctorController {

	
	private DoctorService service;

	public DoctorController(DoctorService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping
	public List<Doctor> getDoctors(){
		
		return this.service.read();
	}
}
