package com.healthcare.api.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class MedicalFileResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String diagnosis;
    private String observation;
    private LocalDate creationDate;

    private Long patientId;
    private String patientCompleteName;
}
