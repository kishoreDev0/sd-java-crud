package com.ta.crud.Login.Service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ta.crud.Login.Dto.Request.LoginRequest;
import com.ta.crud.Login.Dto.Response.LoginResponseDto;
import com.ta.crud.Login.Utilities.Jwt;
import com.ta.crud.Role.Repository.RoleRepository;
import com.ta.crud.User.Entity.User;
import com.ta.crud.User.Repository.UserRepository;
import com.ta.crud.Utilities.Configuration.PasswordConfiguration;
import com.ta.crud.Utilities.Generic.GenericResponse;
import com.ta.crud.Utilities.Generic.GenericResponseBuilder;
import com.ta.crud.Vehicle.Service.VehicleService;

@Service
public class LoginService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private final GenericResponseBuilder genericResponseBuilder;
    private static final Logger log = LoggerFactory.getLogger(LoginService.class);
    private PasswordConfiguration passwordConfiguration;
    private Jwt jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    LoginService(UserRepository userRepository, GenericResponseBuilder genericResponseBuilder,
            RoleRepository roleRepository, PasswordConfiguration passwordConfiguration, Jwt jwtUtil) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordConfiguration = passwordConfiguration;
        this.genericResponseBuilder = genericResponseBuilder;
        this.jwtUtil = jwtUtil;
    }

    public GenericResponse<LoginResponseDto> login(LoginRequest loginRequest) {

        try {
            Optional<User> fetchUser = userRepository.findByEmail(loginRequest.email);
            log.info(fetchUser.get().getEmail() + "");
            User comparedUser = fetchUser.get();
            if (!fetchUser.isPresent()) {
                log.info("No user with the email " + loginRequest.email + " found");
                return genericResponseBuilder.error(200, "User with email " + loginRequest.email + " not found");
            }

            if (passwordEncoder.matches(loginRequest.password, comparedUser.getPassword())) {
                log.info("Password has matched successfully with email" + loginRequest.email + " ");

                // Create JWT Token and their reposibilities
                String accessToken = jwtUtil.generateToken(comparedUser.getFirstName(), comparedUser.getId());

                LoginResponseDto loginReponse = new LoginResponseDto(comparedUser, accessToken);

                return genericResponseBuilder.success(200, true, loginReponse, "Login Authenticated successfully");
            } else {
                log.info("Login service down");
                return genericResponseBuilder.error(403, "Login failed. Please check your credentials and try again");
            }

        } catch (Exception e) {
            log.error("User service has been failed" + e);
            return genericResponseBuilder.error(200, e.getMessage());
        }

    }

}
