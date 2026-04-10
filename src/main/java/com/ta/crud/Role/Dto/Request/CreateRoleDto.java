package com.ta.crud.Role.Dto.Request;

import jakarta.validation.constraints.NotBlank;

public class CreateRoleDto {

    @NotBlank(message = "Role name is should be given")
    public String roleName;
}
