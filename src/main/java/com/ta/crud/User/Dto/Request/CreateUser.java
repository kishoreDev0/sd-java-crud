package com.ta.crud.User.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateUser {

    @NotNull(message = "First name is required")
    public String firstName;

    public String lastName;

    @NotBlank(message = "Email is required")
    public String email;

    @NotNull(message = "Role is required")
    public int role;

    @NotBlank(message = "Status is required")
    public boolean status;

    @NotNull(message = "Password is required")
    public String password;

    @NotNull(message = "Mobile Number is required")
    public long mobileNumber;

}
