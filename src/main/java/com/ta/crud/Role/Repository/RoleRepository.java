package com.ta.crud.Role.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ta.crud.Role.Entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
    
    Optional<Role> findById(long id);  

    Optional<Role> findByRoleName(String name);  

}
