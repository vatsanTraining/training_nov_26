package com.example.demo;

import org.springframework.stereotype.Component;

public class Doctor {

	// instance variable
	
	private String doctorName;
	
	private long phoneNumber;
	
	private String department;
	
	
	
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
//	public Doctor(String doctorName, long phoneNumber, String department) {
//		super();
//		
//		if(doctorName.length() > 3 && doctorName.length()<12) {
//			  this.doctorName = doctorName;
//			}else {
//				throw new RuntimeException("Doctor Name should be 3 to 12 characters");
//			}
//		this.phoneNumber = phoneNumber;
//		this.department = department;
//	}

	public Doctor(String doctorName, long phoneNumber, String department) throws Exception {
		super();
		
		System.out.println("======= Doctor constructor Called =====");
		if(doctorName.length() > 3 && doctorName.length()<12) {
			  this.doctorName = doctorName;
			}else {
				throw new Exception("Doctor Name should be 3 to 12 characters");
			}
		this.phoneNumber = phoneNumber;
		this.department = department;
	}


	public void setDoctorName(String doctorName) {
		
		if(doctorName.length() > 3 && doctorName.length()<12) {
		  this.doctorName = doctorName;
		}else {
			System.out.println("Invalid DoctorName should be 3 to 12 characters");
		}
	}
	
	public String getDoctorName() {
		
		return this.doctorName.toUpperCase();
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return this.doctorName+","+this.department+","+this.phoneNumber;
		
	}
	
	
}
