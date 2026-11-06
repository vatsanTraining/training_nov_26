package com.example.demo.mapper;

import com.example.demo.dto.PatientRequestDto;
import com.example.demo.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public Patient toEntity(PatientRequestDto dto) {
        if (dto == null) {
            return null;
        }
        
        return new Patient(dto.id(),dto.phone(),dto.name(),dto.email());
                
    }

    /**
     * Maps a database entity back to a read-only DTO for API responses.
     */
    public PatientRequestDto toDto(Patient patient) {
        if (patient == null) {
            return null;
        }
        
        return new PatientRequestDto(
        		patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getPhone()
        );
    }
}
