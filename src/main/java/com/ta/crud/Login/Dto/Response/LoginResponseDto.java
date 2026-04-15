package com.ta.crud.Login.Dto.Response;

import com.ta.crud.User.Entity.User;

import lombok.Data;

@Data
public class LoginResponseDto {
    
    private User user;
    private String accessToken;

    public LoginResponseDto(User user, String accessToken) {
        this.user = user;
        this.accessToken = accessToken;
    }
    
}
