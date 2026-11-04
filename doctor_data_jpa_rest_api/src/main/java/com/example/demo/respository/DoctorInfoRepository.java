package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Doctor;

public interface DoctorInfoRepository extends JpaRepository<Doctor, Long> {

}
