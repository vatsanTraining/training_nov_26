package com.example.demo;

import java.util.List;

public interface DoctorService {

	boolean write(Doctor obj) ;
	List<Doctor> read();
}
