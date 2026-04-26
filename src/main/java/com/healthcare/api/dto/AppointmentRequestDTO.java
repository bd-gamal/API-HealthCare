package com.healthcare.api.dto;

import com.healthcare.api.entity.AppointmentStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentRequestDTO {
    @NotNull(message = "The appointment date is mandatory")
    @Future(message = "The date must be in the future")
    private LocalDate appointmentDate;

    @NotNull(message = "The patient ID is mandatory")
    private Long patientId;

    @NotNull(message = "The doctor ID is mandatory")
    private Long doctorId;

    private AppointmentStatus status = AppointmentStatus.PLANNED;
}
