package com.ta.crud.Role.Service;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.ta.crud.Role.Dto.Request.CreateRoleDto;
import com.ta.crud.Role.Dto.Request.UpdateRole;
import com.ta.crud.Role.Entity.Role;
import com.ta.crud.Role.Repository.RoleRepository;
import com.ta.crud.Utilities.Generic.GenericResponse;
import com.ta.crud.Utilities.Generic.GenericResponseBuilder;
import com.ta.crud.Vehicle.Service.VehicleService;
import org.slf4j.Logger;

@Service
public class RoleService {

    private RoleRepository roleRepository;
    private static final Logger log = LoggerFactory.getLogger(VehicleService.class);

    private final GenericResponseBuilder genericResponseBuilder;

    public RoleService(
            RoleRepository roleRepository,
            GenericResponseBuilder genericResponseBuilder) {
        this.roleRepository = roleRepository;
        this.genericResponseBuilder = genericResponseBuilder;
    }

    public GenericResponse<Role> createRole(CreateRoleDto role) {

        try {
            Optional<Role> existingRole = roleRepository.findByRoleName(role.roleName);
            if (!existingRole.isEmpty()) {
                log.debug("Role with name" + role.roleName + " already exists");
                return genericResponseBuilder.error(200, "Role with name" + role.roleName + " already exists");
            }
            // creating a entity
            Role createdRole = new Role(role.roleName);
            // Saving the role entity
            Role savedRole = roleRepository.save(createdRole);
            return genericResponseBuilder.success(200, true, savedRole, "Role has been created successfully");

        } catch (Exception e) {
            log.error("Role with name" + role.roleName + " already exists");
            return genericResponseBuilder.error(200,
                    "Role with name " + role.roleName + " already exists" + e.getMessage());
        }

    }

    public GenericResponse<List<Role>> getAllRoles() {
        try {
            List<Role> roleList = roleRepository.findAll();
            if (roleList.isEmpty()) {
                log.warn("No items found");
                return genericResponseBuilder.error(200, "No items found");
            }

            return genericResponseBuilder.success(204,
                    true,
                    roleList,
                    "Roles fetched successfully");
        } catch (Exception e) {
            log.error("Role service has been failed due to " + e);
            return genericResponseBuilder.error(200, e.getMessage());
        }
    }

    public GenericResponse<Role> updateRole(UpdateRole role, int id) {

        try {
            Optional<Role> existingRole = roleRepository.findById(id);
            if (existingRole.isEmpty()) {
                log.warn("No items found with id " + id);
                return genericResponseBuilder.error(200, "No items found with id " + id);
            }

            existingRole.get().setRoleName(role.roleName);
            existingRole.get().setUpdatedAt(LocalDateTime.now());

            Role savedRole = roleRepository.save(existingRole.get());
            return genericResponseBuilder.success(204,
                    true,
                    savedRole,
                    "Role Updated succesfully");
        } catch (Exception e) {
            log.error("Role service has been failed due to " + e);
            return genericResponseBuilder.error(200, e.getMessage());
        }

    }

}
