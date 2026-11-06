package com.example.demo.mapper;

import com.example.demo.dto.AppointmentRequestDto;
import com.example.demo.entity.Appointment;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

     public Appointment toEntity(AppointmentRequestDto dto, Patient patient, Doctor doctor) {
        if (dto == null || patient == null || doctor == null) {
            return null;
        }
        
         Appointment appointment = new Appointment();
        appointment.setAppointmentTime(dto.appointmentTime());
        appointment.setId(dto.id());
        appointment.setStatus("SCHEDULED"); 
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        
        return appointment;
    }
}
