package com.example.demo.exceptions;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class DoctorApiErrorHandler {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodValidException(BindException ex, 
			WebRequest request) {
		
		Map<String,String> errors = new HashMap<>();
		
		errors.put("URL", request.getDescription(false));
		
		ex.getBindingResult()
		      .getFieldErrors()
		          .forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));
		
		return ResponseEntity.badRequest().body(errors);
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String,String>> handleRunTimeException(RuntimeException ex, 
			WebRequest request) {
		
		Map<String,String> errors = new HashMap<>();
		
		errors.put("URL", request.getDescription(false));
		errors.put("message", ex.getMessage());
		
		
		return ResponseEntity.badRequest().body(errors);
	}
	
}
