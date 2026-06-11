package com.healthcare.api.dto;

import com.healthcare.api.entity.AppointmentStatus;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AppointmentResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDateTime appointmentDate;
    private AppointmentStatus status;
    private String patientCompleteName;
    private String doctorName;
    private String doctorSpecialty;
}
