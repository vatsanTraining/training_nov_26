package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

import com.example.demo.Doctor;
import com.example.demo.DoctorService;

public class DoctorServiceFileImpl implements DoctorService {

	
	
	public DoctorServiceFileImpl() {
		super();
		
	}

	
	@Override
	public boolean write(Doctor obj) {
		
		boolean status = false;
		
		try(PrintWriter writer =
				new PrintWriter(
						new FileWriter(
								new File("doctors.txt"),true))){
			
			writer.println(obj);
			status = true;
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
				
		
		return status;
	}

	@Override
	public List<Doctor> read() {

		List<Doctor> docList = new ArrayList<>();
		
		try(BufferedReader reader = 
				new BufferedReader(
						new FileReader(new File("doctors.txt")))){
			
			String line;
			while( (line =reader.readLine())!=null) {
				
				var values = line.split(",");
				
				Doctor doctor = 
						new Doctor(values[0], 
								Long.parseLong(values[2]),values[1]);
				
				docList.add(doctor);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return docList;
	}

}



