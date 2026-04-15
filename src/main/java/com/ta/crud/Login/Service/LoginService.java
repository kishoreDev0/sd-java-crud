package com.ta.crud.Login.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ta.crud.Login.Dto.Request.LoginRequest;
import com.ta.crud.Role.Repository.RoleRepository;
import com.ta.crud.User.Entity.User;
import com.ta.crud.User.Repository.UserRepository;
import com.ta.crud.Utilities.Generic.GenericResponse;
import com.ta.crud.Utilities.Generic.GenericResponseBuilder;
import com.ta.crud.Vehicle.Service.VehicleService;

public class LoginService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private final GenericResponseBuilder genericResponseBuilder;
    private static final Logger log = LoggerFactory.getLogger(VehicleService.class);

    LoginService(UserRepository userRepository, GenericResponseBuilder genericResponseBuilder,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.genericResponseBuilder = genericResponseBuilder;
    }

    public GenericResponse<User> login(LoginRequest loginRequest){{

    }} 
    
}
