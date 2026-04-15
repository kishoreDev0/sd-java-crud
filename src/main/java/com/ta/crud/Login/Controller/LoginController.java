package com.ta.crud.Login.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ta.crud.Login.Dto.Request.LoginRequest;
import com.ta.crud.Login.Dto.Response.LoginResponseDto;
import com.ta.crud.Login.Service.LoginService;
import com.ta.crud.User.Dto.Request.CreateUser;
import com.ta.crud.User.Entity.User;
import com.ta.crud.User.Service.UserService;
import com.ta.crud.Utilities.Generic.GenericResponse;
import com.ta.crud.Vehicle.Service.VehicleService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
@Tag(name = "Login API", description = "Operations related to login")
public class LoginController {

    private UserService userService;
    private LoginService loginService;

    LoginController(UserService userService ,LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public GenericResponse<LoginResponseDto> Login(@RequestBody LoginRequest loginRequest) {
        GenericResponse<LoginResponseDto> loginUser = loginService.login(loginRequest);
        return loginUser;

    }

    @PostMapping("/logout")
    public void LogOut() {

    }

    @PostMapping("/signup")
    public GenericResponse<User> SignUp(@RequestBody @Valid CreateUser createUser) {

        // checking the user exist or not
        GenericResponse<User> createdUserResponse = userService.createUser(createUser);
        return createdUserResponse;

    }

}
