package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DoctorInfoService;
import com.example.demo.entity.Doctor;

@RestController
@RequestMapping(path = "/api/v1/doctors")
public class DoctorController {

	
	private  DoctorInfoService service;

	public DoctorController(DoctorInfoService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Doctor>> findAll(){
		
		return ResponseEntity.ok(this.service.findAll());
		
		
	}
}
