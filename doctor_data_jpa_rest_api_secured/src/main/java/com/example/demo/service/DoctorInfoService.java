package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.mapper.DoctorMapper;
import com.example.demo.respository.DoctorInfoRepository;

import jakarta.transaction.Transactional;

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
   
   public void removeDoctor(long phoneNumber) {
       if (!repository.existsById(phoneNumber)) {
           throw new RuntimeException("Phone Number:=>" + phoneNumber + ":=>Not Found for deletion");
       }
       repository.deleteById(phoneNumber);
   }

//   public DoctorDto updateDepartment(long phoneNumber, String newDept) {
//       Doctor doc = repository.findById(phoneNumber)
//               .orElseThrow(() -> new RuntimeException("Phone Number:=>" + phoneNumber + ":=>Not Found"));
//       
//       doc.setDepartment(newDept); 
//              Doctor updatedDoc = repository.save(doc);
//       return this.mapper.toDto(updatedDoc);
//   }

   @Transactional
   public DoctorDto updateDepartment(long phoneNumber, String newDept) {
	   
	   
       int  count = repository.updateDepartment(phoneNumber, newDept);
       if(count ==1) {
    	   return findById(phoneNumber);   
       } else {
    	   throw new RuntimeException("Element With Given Id Not found");
       }
       
       
   }
   public List<DoctorDto> findAllSortedByDepartment() {
       List<Doctor> docList = repository.findAll(Sort.by(Sort.Direction.ASC, Doctor::getDepartment));
       return docList.stream().map(mapper::toDto).toList();
   }

   public Page<DoctorDto> findAllPaginated(int pageNo, int pageSize) {
       Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Doctor::getDepartment)
    		      .ascending());
       Page<Doctor> docPage = repository.findAll(pageable);
       return docPage.map(mapper::toDto);
   }
}
