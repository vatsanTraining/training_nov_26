package com.example.demo.controllers;

import com.example.demo.dto.AppointmentRequestDto;
import com.example.demo.entity.Appointment;
import com.example.demo.service.AppointmentService;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
@Tag(name = "Appointment Management", description = "Endpoints for booking and viewing healthcare schedule slots")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')") 
     @Operation(summary = "Book a new healthcare appointment")
    @ApiResponses(value = { /* Swagger Docs */ })
    public ResponseEntity<Appointment> bookAppointment(@Valid @RequestBody AppointmentRequestDto dto) {
        Appointment savedAppointment = appointmentService.bookAppointment(dto);
        return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
    }

    @GetMapping("/doctor/{doctorId}")
    @PreAuthorize("hasRole('ADMIN') or (hasRole('DOCTOR') and #doctorId == authentication.principal.username)") 
    @Operation(summary = "Retrieve appointments assigned to a specific doctor")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctor(@PathVariable Long doctorId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByDoctor(doctorId);
        return ResponseEntity.ok(appointments);
    }
    
    @PatchMapping("/{id}/cancel")
    public ResponseEntity<Appointment> cancelAppointment(
            @PathVariable Long id,
            @RequestParam Long doctorId,
            @RequestParam Long patientId) {
        
        Appointment cancelledAppointment = appointmentService.cancelAppointment(id, doctorId, patientId);
        return ResponseEntity.ok(cancelledAppointment);
    }
}
