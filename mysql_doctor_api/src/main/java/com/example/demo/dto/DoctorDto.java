package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record DoctorDto(
		@NotEmpty
		@Size(min = 3,max = 12,message = "doctorName should be 3 to 12 characters")
		String doctorName,
	    long phoneNumber,
		String department
		) {

}
