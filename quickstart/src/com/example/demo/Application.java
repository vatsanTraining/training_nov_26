package com.example.demo;

public class Application {

	public static void main(String[] args) {
		

		Doctor ram = new Doctor();
		
		
		 ram.setDoctorName("Ramesh");
		 ram.setDepartment("ENT");
		 ram.setPhoneNumber(984858323);
		 
		 System.out.println(ram.getDoctorName());

		 System.out.println(ram.getDepartment());
		 System.out.println(ram.getPhoneNumber());
		 
		 
		 Doctor shyam;
		try {
			shyam = new Doctor("Sh",8484848,"Dental");
			 System.out.println(shyam);

		} catch (Exception e) {
			e.printStackTrace();
		}

//		 System.out.println(shyam.getDoctorName());
//
//		 System.out.println(shyam.getDepartment());
//		 System.out.println(shyam.getPhoneNumber());

	}

}
