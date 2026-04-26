package com.healthcare.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRequestDTO {
    @NotBlank(message = "The last name is mandatory")
    private String lastName;

    @NotBlank(message = "The first name is mandatory")
    private String firstName;

    @Email(message = "Email invalid")
    @NotBlank(message = "The email is mandatory")
    private String email;

    @NotBlank(message = "The phone number is mandatory")
    private String phone;

    @NotNull(message = "The date of birth is mandatory")
    @Past(message = "The date of birth must be in the past")
    private LocalDate birthDate;
}
