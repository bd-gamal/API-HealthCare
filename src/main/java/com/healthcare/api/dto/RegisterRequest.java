package com.healthcare.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank(message = "The username is mandatory")
    @Size(min = 3, max = 20, message = "The username must contain 3 to 20 characters")
    private String username;

    @NotBlank(message = "The email is mandatory")
    @Email(message = "The email format is invalid")
    private String email;

    @NotBlank(message = "The password is mandatory")
    @Size(min = 6, message = "The password must contain at least 6 characters")
    private String password;
}
