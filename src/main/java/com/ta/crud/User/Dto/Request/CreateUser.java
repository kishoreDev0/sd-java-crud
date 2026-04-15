package com.ta.crud.User.Dto.Request;

import jakarta.validation.constraints.*;

public class CreateUser {

    @NotBlank(message = "First name is required")
    public String firstName;

    public String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    public String email;

    @NotNull(message = "Role is required")
    public Integer role;

    @NotNull(message = "Status is required")
    public Boolean status;

    @NotBlank(message = "Password is required")
    public String password;

    @NotNull(message = "Mobile Number is required")
    public Long mobileNumber;
}