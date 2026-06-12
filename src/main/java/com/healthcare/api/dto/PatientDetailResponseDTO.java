package com.healthcare.api.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class PatientDetailResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private String phone;
    private LocalDate birthDate;

    private List<AppointmentResponseDTO> appointmentList;
}