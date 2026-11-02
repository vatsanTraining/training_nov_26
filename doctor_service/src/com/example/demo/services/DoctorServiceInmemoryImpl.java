package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Doctor;
import com.example.demo.DoctorService;

public class DoctorServiceInmemoryImpl implements DoctorService {

	
	private List<Doctor> doctorList;
	
	
	
	public DoctorServiceInmemoryImpl() {
		super();
		this.doctorList = new ArrayList<>();
	}

	@Override
	public boolean write(Doctor obj) {
		
		return this.doctorList.add(obj);
	}

	@Override
	public List<Doctor> read() {

		return this.doctorList;
	}

}
