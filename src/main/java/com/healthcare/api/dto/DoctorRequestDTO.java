package com.healthcare.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DoctorRequestDTO {
    @NotBlank(message = "The doctor name is mandatory")
    private String name;

    @NotBlank(message = "The specialty is mandatory")
    private String specialty;

    @Email(message = "Email format is invalid")
    @NotBlank(message = "The email is mandatory")
    private String email;

    @NotBlank(message = "The phone number is mandatory")
    private String phone;
}
