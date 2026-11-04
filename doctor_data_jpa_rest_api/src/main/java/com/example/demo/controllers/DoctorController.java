package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DoctorInfoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

import com.example.demo.dto.DoctorDto;
import com.example.demo.entity.Doctor;

@RestController
@RequestMapping(path = "/api/v1/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {

	
	private  DoctorInfoService service;

	public DoctorController(DoctorInfoService service) {
		super();
		this.service = service;
		
		
	}
	
	
	@GetMapping
	@Operation(description = "Feteches the Details of Doctors")
	public ResponseEntity<List<DoctorDto>> findAll(){
		
		return ResponseEntity.ok(this.service.findAll());
		
		
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<DoctorDto> findAll(@PathVariable long id){
		
		return ResponseEntity.ok(this.service.findById(id));
		
		
	}
	
	@GetMapping(path = "/srch/dept/{dept}")
	public ResponseEntity<List<DoctorDto>> findByDepartment(@PathVariable String  dept){
		
		return ResponseEntity.ok(this.service.findByDepartment(dept));
		
		
	}
	@PostMapping
	public ResponseEntity<DoctorDto> save(@Valid @RequestBody DoctorDto dto){
		
		 DoctorDto saved = this.service.addDoctor(dto);
		 
		 return ResponseEntity.status(201).body(saved);
	}
	
	//Add the following mapping
	// @Delete, @Put, @Patch
	// Add Pagination and sort By doctName or department
	
}
