package com.healthcare.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "The username is mandatory")
    private String username;

    @NotBlank(message = "The password is mandatory")
    private String password;
}
