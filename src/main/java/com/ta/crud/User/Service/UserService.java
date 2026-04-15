package com.ta.crud.User.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ta.crud.User.Repository.UserRepository;
import com.ta.crud.Utilities.Generic.GenericResponse;
import com.ta.crud.Utilities.Generic.GenericResponseBuilder;
import com.ta.crud.Vehicle.Service.VehicleService;
import com.ta.crud.Role.Entity.Role;
import com.ta.crud.Role.Repository.RoleRepository;
import com.ta.crud.User.Dto.Request.CreateUser;
import com.ta.crud.User.Entity.*;;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private final GenericResponseBuilder genericResponseBuilder;
    private static final Logger log = LoggerFactory.getLogger(VehicleService.class);
    private final PasswordEncoder passwordEncoder;

    UserService(UserRepository userRepository, GenericResponseBuilder genericResponseBuilder,
            RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.genericResponseBuilder = genericResponseBuilder;
        this.passwordEncoder = passwordEncoder;
    }

    public GenericResponse<List<User>> getAllUsers() {
        try {
            List<User> userList = userRepository.findAll();
            if (userList.isEmpty()) {
                log.warn("No items found");
                return genericResponseBuilder.error(200, "No items found");
            }
            return genericResponseBuilder.success(204,
                    true,
                    userList,
                    "Users fetched successfully");

        } catch (Exception e) {
            log.error("Vehical service has been failed" + e);
            return genericResponseBuilder.error(200, e.getMessage());
        }
    }

    public GenericResponse<User> getUserById(int id) {
        try {
            Optional<User> userFeteched = userRepository.findById((Integer) id);
            if (userFeteched.isEmpty()) {
                log.info("No user with the id " + id + " found");
                return genericResponseBuilder.error(200, "User with id " + id + " not found");
            }
            return genericResponseBuilder.success(204,
                    true,
                    userFeteched.get(),
                    "User with id " + id + " fetched successfully");
        } catch (Exception e) {
            log.error("User service has been failed" + e);
            return genericResponseBuilder.error(200, e.getMessage());
        }
    }

    public GenericResponse<User> getUserByPhone(long phone) {
        try {
            Optional<User> userFeteched = userRepository.findBymobileNumber(phone);
            if (userFeteched.isEmpty()) {
                log.info("No user with the phone number " + phone + " found");
                return genericResponseBuilder.error(200, "User with phone " + phone + " not found");
            }
            return genericResponseBuilder.success(204,
                    true,
                    userFeteched.get(),
                    "User with phone " + phone + " fetched successfully");
        } catch (Exception e) {
            log.error("User service has been failed" + e);
            return genericResponseBuilder.error(200, e.getMessage());
        }
    }

    public GenericResponse<User> getUserByEmail(String email) {
        try {
            Optional<User> userFeteched = userRepository.findByEmail(email);
            if (userFeteched.isEmpty()) {
                log.info("No user with the email " + email + " found");
                return genericResponseBuilder.error(200, "User with email " + email + " not found");
            }
            return genericResponseBuilder.success(204,
                    true,
                    userFeteched.get(),
                    "User with email " + email + " fetched successfully");
        } catch (Exception e) {
            log.error("User service has been failed" + e);
            return genericResponseBuilder.error(200, e.getMessage());
        }
    }

    // Creating a user
    public GenericResponse<User> createUser(CreateUser createUserDto) {
        try {

            // Email checking
            Optional<User> existingEmail = userRepository.findByEmail(createUserDto.email);
            if (existingEmail.isPresent()) {
                log.info("Email with" + createUserDto.email + " ");
                return genericResponseBuilder.error(200,
                        "User with email " + createUserDto.email + " already present");
            }

            // Email phoneNumber
            Optional<User> existingPhone = userRepository.findBymobileNumber(createUserDto.mobileNumber);
            if (existingPhone.isPresent()) {
                log.info("Phone with " + createUserDto.mobileNumber + " With already present");
                return genericResponseBuilder.error(200,
                        "User with phone " + createUserDto.mobileNumber + " already present");
            }

            // Chwcking exiting role
            Optional<Role> exisitingRole = roleRepository.findById(createUserDto.role);

            // Encrypting password
            User user = new User(createUserDto.firstName, createUserDto.lastName, createUserDto.email,
                    exisitingRole.get(), true, passwordEncoder.encode(createUserDto.password),
                    createUserDto.mobileNumber);
                    User savedUser  = userRepository.save(user);

            return genericResponseBuilder.success(204,
                    true,
                    savedUser,
                    "User has successfully created");
        } catch (Exception e) {
            log.error("User service has been failed" + e);
            return genericResponseBuilder.error(200, e.getMessage());
        }
    }

}
