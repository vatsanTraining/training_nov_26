package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DoctorInfoService;
import com.example.demo.dto.DoctorDto;
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
	public ResponseEntity<List<DoctorDto>> findAll(){
		
		return ResponseEntity.ok(this.service.findAll());
		
		
	}
	
	@PostMapping
	public ResponseEntity<DoctorDto> save(@RequestBody DoctorDto dto){
		
		 DoctorDto saved = this.service.addDoctor(dto);
		 
		 return ResponseEntity.status(201).body(saved);
	}
}
