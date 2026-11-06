package com.example.demo.dto;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Payload contract required to book a new appointment slot")
public record AppointmentRequestDto(
    Long id,
    @Schema(description = "Unique database primary key identifier of the patient", example = "1")
    @NotNull(message = "Patient ID is required")
    Long patientId,

    @Schema(description = "Unique database primary key identifier of the doctor", example = "4")
    @NotNull(message = "Doctor ID is required")
    Long doctorId,

    @Schema(description = "Target date and time for the medical booking (Must be a future window)", example = "2026-11-15T10:30:00")
    @NotNull(message = "Appointment date and time are required")
    @Future(message = "Appointment date must be scheduled in the future")
    LocalDateTime appointmentTime
) {}
