package com.ta.crud.Login.Dto.Request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LoginRequest {

    @NotBlank(message = "Email is required")
    public String email;

    @NotNull(message = "Password is required")
    public String password;

}

