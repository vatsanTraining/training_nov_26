package com.example.demo.service;

import com.example.demo.dto.AppointmentRequestDto;
import com.example.demo.entity.Appointment;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.exceptions.InvalidAppointmentStateException;
import com.example.demo.mapper.AppointmentMapper;
import com.example.demo.respository.AppointmentRepository;
import com.example.demo.respository.DoctorInfoRepository;
import com.example.demo.respository.PatientRepository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorInfoRepository doctorRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository,
			DoctorInfoRepository doctorRepository, AppointmentMapper appointmentMapper) {
		super();
		this.appointmentRepository = appointmentRepository;
		this.patientRepository = patientRepository;
		this.doctorRepository = doctorRepository;
		this.appointmentMapper = appointmentMapper;
	}

	public Appointment bookAppointment(AppointmentRequestDto dto) {

    	Patient patient = patientRepository.findById(dto.patientId())
                .orElseThrow(() -> new RuntimeException("Patient profile record not found with ID: " + dto.patientId()));

        Doctor doctor = doctorRepository.findById(dto.doctorId())
                .orElseThrow(() -> new RuntimeException("Doctor profile record not found with ID: " + dto.doctorId()));

         boolean isConflict = appointmentRepository.existsByDoctorIdAndAppointmentTime(dto.doctorId(), dto.appointmentTime());
        if (isConflict) {
            throw new IllegalStateException("Scheduling conflict detected: The doctor is already booked at this time slot.");
        }

        Appointment appointmentEntity = appointmentMapper.toEntity(dto, patient, doctor);

        return appointmentRepository.save(appointmentEntity);
    }

	public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
				return appointmentRepository.findByDoctorId(doctorId);
				
	}
	
	public List<Appointment> getAppointmentByPatient(Long patientId){
		
		return appointmentRepository.findByPatientId(patientId);
	}
	
	@Transactional
    public Appointment cancelAppointment(Long appointmentId, Long doctorId, Long patientId) {
        Appointment appointment = appointmentRepository
            .findByIdAndDoctorIdAndPatientId(appointmentId, doctorId, patientId)
            .orElseThrow(() -> new RuntimeException("Appointment not found for this doctor and patient"));

        if ("COMPLETED".equalsIgnoreCase(appointment.getStatus())) {
            throw new InvalidAppointmentStateException("Cannot cancel an appointment that has already been completed.");
        }

        if ("CANCELLED".equalsIgnoreCase(appointment.getStatus())) {
            throw new InvalidAppointmentStateException("This appointment is already cancelled.");
        }

        if (appointment.getAppointmentTime().isBefore(LocalDateTime.now())) {
            throw new InvalidAppointmentStateException("Cannot cancel an appointment that has already occurred.");
        }

        appointment.setStatus("CANCELLED");
        return appointmentRepository.save(appointment);
    }	
}
