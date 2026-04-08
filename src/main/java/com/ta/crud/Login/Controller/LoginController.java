package com.ta.crud.Login.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ta.crud.Login.Dto.Request.LoginRequest;
import com.ta.crud.Login.Dto.Request.SignupRequest;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/")
public class LoginController {

    @PostMapping("/login")
    public void Login(@RequestBody LoginRequest loginrequest) {

    }

    @PostMapping("/logout")
    public void LogOut() {

    }

    @PostMapping("/signup")
    public void SignUp(@RequestBody SignupRequest signUpRequest) {

        

    }

}
