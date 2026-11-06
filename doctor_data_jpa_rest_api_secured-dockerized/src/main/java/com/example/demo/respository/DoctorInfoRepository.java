package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Doctor;

import jakarta.transaction.Transactional;

public interface DoctorInfoRepository extends JpaRepository<Doctor, Long> {

	List<Doctor> findByDepartment(String key);
	

	List<Doctor> findByDoctorName(String key);
	
	
   @Query(value ="update Doctor set department=:newDept where phoneNumber=:phoneNumber",nativeQuery = false)
   @Modifying
   @Transactional
   int updateDepartment(@Param("phoneNumber")  long phoneNumber, @Param("newDept") String newDept); 
}
