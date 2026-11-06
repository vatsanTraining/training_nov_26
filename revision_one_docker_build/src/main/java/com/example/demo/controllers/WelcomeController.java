package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/greet")
public class WelcomeController {

	
	@GetMapping
	public String getMessage() {
		
		return "Welcome to Dockerized App";
	}
}
