package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor_nov_26")
public class Doctor {

	@Column(name = "id")
	private Long id;
	
	@Column(name = "doctor_name")
	private String doctorName;

	@Id
	@Column(name = "phone_number")
	private long phoneNumber;
	
	@Column(name = "department")
	private String department;
	
		
	public Doctor() {
		super();
	}

	

	public Doctor(String doctorName, long phoneNumber, String department)  {
		super();
		
			  this.doctorName = doctorName;
			this.phoneNumber = phoneNumber;
		   this.department = department;
	}


	public void setDoctorName(String doctorName) {
		
		  this.doctorName = doctorName;
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
