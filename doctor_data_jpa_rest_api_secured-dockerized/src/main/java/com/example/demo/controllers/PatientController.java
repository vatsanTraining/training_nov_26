package com.example.demo.controllers;

import com.example.demo.dto.PatientRequestDto;
import com.example.demo.entity.Patient;
import com.example.demo.mapper.PatientMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientMapper patientMapper;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')") 
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody PatientRequestDto dto) {
        Patient patientEntity = patientMapper.toEntity(dto);
        return new ResponseEntity<>(patientEntity, HttpStatus.CREATED);
    }
    
    @GetMapping
    public String getPatient() {
    	
    	return "Patient Details";
    }
}
