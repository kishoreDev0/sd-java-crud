package com.ta.crud.Role.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ta.crud.Generic.GenericResponse;
import com.ta.crud.Role.Dto.Request.CreateRoleDto;
import com.ta.crud.Role.Dto.Request.UpdateRole;
import com.ta.crud.Role.Entity.Role;
import com.ta.crud.Role.Repository.RoleRepository;
import com.ta.crud.Role.Service.RoleService;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/role")
public class RoleController {

    private RoleService roleService;

    RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    public GenericResponse<List<Role>> getAllRole() {
        GenericResponse<List<Role>> roleList = roleService.getAllRoles();
        return roleList;
    }

    @PostMapping("")
    public GenericResponse<Role> createRole(@RequestBody CreateRoleDto createRole) {
        GenericResponse<Role> roleSaved = roleService.createRole(createRole);
        return roleSaved;
    }
    @PutMapping("path/{id}")
    public GenericResponse<Role> updateRole(@PathVariable Long id, @RequestBody UpdateRole role) {
        GenericResponse<Role> roleUpdated= roleService.updateRole(role,id);
        return roleUpdated;
    }

}
