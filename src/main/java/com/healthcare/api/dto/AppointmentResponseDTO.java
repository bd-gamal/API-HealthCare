package com.healthcare.api.dto;

import com.healthcare.api.entity.AppointmentStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResponseDTO {
    private Long id;
    private LocalDateTime appointmentDate;
    private AppointmentStatus status;
    private String patientCompleteName;
    private String doctorName;
    private String doctorSpecialty;
}
