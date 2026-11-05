package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Doctor;

public interface DoctorInfoRepository extends JpaRepository<Doctor, Long> {

	List<Doctor> findByDepartment(String key);
	

	List<Doctor> findByDoctorName(String key);
	
	
	
}
