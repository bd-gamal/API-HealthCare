package com.healthcare.api.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class DoctorResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String specialty;
    private String email;
    private String phone;
}
