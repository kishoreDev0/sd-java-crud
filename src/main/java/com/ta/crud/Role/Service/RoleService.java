package com.ta.crud.Role.Service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.ta.crud.Generic.GenericResponse;
import com.ta.crud.Generic.GenericResponseBuilder;
import com.ta.crud.Role.Entity.Role;
import com.ta.crud.Role.Repository.RoleRepository;
import com.ta.crud.Vehicle.Service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
    private static final Logger log = LoggerFactory.getLogger(VehicleService.class);
    private GenericResponseBuilder genericResponseBuilder;

    public GenericResponse<Role> createRole(Role role) {

        try {
            Optional<Role> existingRole = roleRepository.findByRoleName(role.getRoleName());
            if (!existingRole.isEmpty()) {
                log.debug("Role with name" + role.getRoleName() + " already exists");
                return genericResponseBuilder.error(200, "Role with name" + role.getRoleName() + " already exists");
            }
            // creating a entity
            Role createdRole = new Role(role.getRoleName());
            // Saving the role entity
            Role savedRole = roleRepository.save(createdRole);
            return genericResponseBuilder.success(200, true, savedRole, "Role has been created successfully");

        } catch (Exception e) {
            log.error("Role with name" + role.getRoleName() + " already exists");
            return genericResponseBuilder.error(200,
                    "Role with name" + role.getRoleName() + " already exists" + e.getMessage());
        }

    }

}
