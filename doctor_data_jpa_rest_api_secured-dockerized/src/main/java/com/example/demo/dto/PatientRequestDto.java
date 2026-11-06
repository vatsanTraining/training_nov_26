package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PatientRequestDto(
    
	long id,	
	@NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    String name,

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Please provide a valid email address")
    String email,

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Phone number must be between 10 and 15 digits")
    String phone
) {}
