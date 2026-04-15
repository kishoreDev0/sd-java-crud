package com.ta.crud.Login.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ta.crud.Login.Dto.Request.LoginRequest;
import com.ta.crud.Login.Dto.Request.SignupRequest;
import com.ta.crud.Role.Repository.RoleRepository;
import com.ta.crud.User.Dto.Request.CreateUser;
import com.ta.crud.User.Entity.User;
import com.ta.crud.User.Repository.UserRepository;
import com.ta.crud.User.Service.UserService;
import com.ta.crud.Utilities.Generic.GenericResponse;
import com.ta.crud.Utilities.Generic.GenericResponseBuilder;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/")
@Tag(name = "Login API", description = "Operations related to login")
public class LoginController {

    private UserService userService;

    LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public void Login(@RequestBody LoginRequest loginRequest) {
        

    }

    @PostMapping("/logout")
    public void LogOut() {

    }

    @PostMapping("/signup")
    public GenericResponse<User> SignUp(@RequestBody CreateUser createUser) {

        // checking the user exist or not
        GenericResponse<User> createdUserResponse = userService.createUser(createUser);
        return createdUserResponse;

    }

}
