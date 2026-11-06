package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.DoctorDto;
import com.example.demo.entity.Doctor;

@Component
public class DoctorMapper {

	
	public DoctorDto toDto(Doctor doctor) {
		
		return new DoctorDto(doctor.getDoctorName(), doctor.getPhoneNumber(), doctor.getDepartment());
		
	}
	
	public Doctor toEntity(DoctorDto dto) {
		
		return new Doctor(dto.doctorName(),dto.phoneNumber(),dto.department());
	}
	
}
