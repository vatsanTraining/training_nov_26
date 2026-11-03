package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
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
