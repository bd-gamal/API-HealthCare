package com.healthcare.api.dto;

import com.healthcare.api.entity.AppointmentStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentResponseDTO {
    private Long id;
    private LocalDate appointmentDate;
    private AppointmentStatus status;
    private String patientCompleteName;
    private String doctorName;
    private String doctorSpecialty;
}
