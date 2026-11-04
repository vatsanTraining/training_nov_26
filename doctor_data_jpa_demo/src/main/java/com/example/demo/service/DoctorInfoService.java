package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.respository.DoctorInfoRepository;

@Service
public class DoctorInfoService {

	private DoctorInfoRepository repository;

	public DoctorInfoService(DoctorInfoRepository repository) {
		super();
		this.repository = repository;
	}
	
	
	public Doctor addDoctor(Doctor doctor) {
		
		return this.repository.save(doctor);
	}
	
	public List<Doctor> findAll(){
		
		return this.repository.findAll();
	}
}
