package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DoctorApplication {


//	@Autowired
//	private DoctorService service;
//	
	
	private DoctorService service;

//	//constructor injection with @Qualifier
//	public DoctorApplication(@Qualifier("doctorServiceInmemoryImpl") DoctorService service) {
//		super();
//		this.service = service;
//	}

	//constructor injection
		public DoctorApplication(DoctorService service) {
			super();
			this.service = service;
		}
	public List<Doctor> getDoctors(){
		
		return this.service.read();
	}
	
	public boolean addDoctor(Doctor doc) {
		
		return this.service.write(doc);
	}
}
