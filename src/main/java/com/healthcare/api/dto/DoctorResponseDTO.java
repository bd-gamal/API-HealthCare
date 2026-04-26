package com.healthcare.api.dto;

import lombok.Data;

@Data
public class DoctorResponseDTO {
    private Long id;
    private String name;
    private String specialty;
    private String email;
    private String phone;
}
