package com.ta.crud.Role.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ta.crud.Role.Entity.Role;


public interface RoleRepository extends JpaRepository<Role,Integer> {
    
    Optional<Role> findById(int id);  

    Optional<Role> findByRoleName(String name); 
    
    

}
