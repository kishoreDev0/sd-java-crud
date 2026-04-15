package com.ta.crud.User.Repository;

import org.springframework.stereotype.Repository;

import com.ta.crud.User.Entity.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ta.crud.Role.Entity.Role;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findById(int id);

    Optional<User> findBymobileNumber(long number);

    List<User> findByRole(Role role);

    List<User> findByStatus(boolean status);

    Optional<User> findByEmail(String email);


}
