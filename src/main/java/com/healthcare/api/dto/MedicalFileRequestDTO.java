package com.healthcare.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicalFileRequestDTO {
    @NotNull(message = "The patient ID is mandatory to create a file")
    private Long patientId;

    @NotBlank(message = "The diagnosis is mandatory")
    private String diagnosis;

    @NotBlank(message = "The observation is mandatory")
    private String observation;

    private LocalDate creationDate;
}
