package com.example.demo.service;

import com.example.demo.dto.PatientRequestDto;
import com.example.demo.entity.Patient;
import com.example.demo.mapper.PatientMapper;
import com.example.demo.respository.PatientRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PatientService  {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    public Patient registerPatient(PatientRequestDto dto) {
        patientRepository.findByEmail(dto.email()).ifPresent(p -> {
            throw new IllegalArgumentException("A patient with this email already exists.");
        });

        Patient patientEntity = patientMapper.toEntity(dto);
        return patientRepository.save(patientEntity);
    }

    @Transactional(readOnly = true)
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
