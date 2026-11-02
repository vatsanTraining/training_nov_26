package com.example.demo.services;

import com.example.demo.Doctor;
import com.example.demo.DoctorService;

public class Application {

	public static void main(String[] args) {

		DoctorService service = new DoctorServiceFileImpl();
		
		try {
		System.out.println("is written:=>"+
		service.write(new Doctor("Ramesh",93929239,"ENT")));

		System.out.println("is written:=>"+
       service.write(new Doctor("Ganesh",73329237,"Dentist")));
		
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 System.out.println(service.read());
	
		DoctorService inmemory = new DoctorServiceInmemoryImpl();
		

		try {
			System.out.println("is written:=>"+
			inmemory.write(new Doctor("T.Ramesh",93929239,"ENT")));

			System.out.println("is written:=>"+
	       inmemory.write(new Doctor("T.Ganesh",73329237,"Dentist")));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		 System.out.println(inmemory.read());
	}

}
