package com.ta.crud.Login.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ta.crud.User.Entity.User;

public interface LoginRepository extends JpaRepository<User,Integer>{

    // Optional<User> 
} 
