package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.mapper.DoctorMapper;
import com.example.demo.respository.DoctorInfoRepository;
import com.example.demo.dto.*;
@Service
public class DoctorInfoService {

	private DoctorInfoRepository repository;
	private DoctorMapper mapper;

	public DoctorInfoService(DoctorInfoRepository repository,DoctorMapper mapper) {
		super();
		
		System.out.println("Repo Implementation =>"+repository.getClass().getName());
		this.repository = repository;
		this.mapper = mapper;
	}
	
	
	public DoctorDto addDoctor(DoctorDto dto) {
		
		Doctor saved = this.repository.save(mapper.toEntity(dto));
		
		return this.mapper.toDto(saved);
		
	}
	
	public List<DoctorDto> findAll(){
		
		List<Doctor> docList =this.repository.findAll();
		
		return docList.stream().map(mapper::toDto).toList();
		
		
	}
	
	public DoctorDto findById(long phoneNumber) {
		
		Doctor doc=repository.findById(phoneNumber)
				 .orElseThrow(() -> new RuntimeException("Phone Number:=>"+phoneNumber+ ":=>Not Found"));
		
		return this.mapper.toDto(doc);
	}
	
   public List<DoctorDto> findByDepartment(String dept){
		
		List<Doctor> docList =this.repository.findByDepartment(dept);
		
		return docList.stream().map(mapper::toDto).toList();
		
		
	}
	
}
