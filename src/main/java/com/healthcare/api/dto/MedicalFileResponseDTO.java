package com.healthcare.api.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicalFileResponseDTO {
    private Long id;
    private String diagnosis;
    private String observation;
    private LocalDate creationDate;

    private Long patientId;
    private String patientCompleteName;
}
