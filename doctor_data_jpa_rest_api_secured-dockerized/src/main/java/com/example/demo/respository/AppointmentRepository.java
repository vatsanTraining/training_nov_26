package com.example.demo.respository;

import com.example.demo.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

       List<Appointment> findByDoctorId(Long doctorId);

       List<Appointment> findByPatientId(Long patientId);

    boolean existsByDoctorIdAndAppointmentTime(Long doctorId, LocalDateTime appointmentTime);
    
    // Find a specific appointment belonging to a doctor and a patient
    Optional<Appointment> findByIdAndDoctorIdAndPatientId(Long id, Long doctorId, Long patientId);

}
