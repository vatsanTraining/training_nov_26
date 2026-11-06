package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.service.DoctorInfoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

import com.example.demo.dto.DoctorDto;

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
	@Operation(description = "Fetches the Details of Doctors")
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
		 
		 URI location=
		           ServletUriComponentsBuilder
		          .fromCurrentRequest()
		         .path("/{id}")
		          .buildAndExpand(saved.phoneNumber())
		          .toUri();  

		 return ResponseEntity.created(location).body(saved);
	}
	
    @DeleteMapping("/{phoneNumber}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable long phoneNumber) {
        service.removeDoctor(phoneNumber);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{phoneNumber}/department")
    public ResponseEntity<DoctorDto> patchDepartment(
            @PathVariable long phoneNumber, 
            @RequestParam String newDept) {
        DoctorDto updated = service.updateDepartment(phoneNumber, newDept);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<DoctorDto>> getAllSorted() {
        return ResponseEntity.ok(service.findAllSortedByDepartment());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<DoctorDto>> getAllPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(service.findAllPaginated(page, size));
    }

  
}
	

