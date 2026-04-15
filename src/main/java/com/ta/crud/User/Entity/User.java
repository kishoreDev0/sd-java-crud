package com.ta.crud.User.Entity;

import java.time.LocalDateTime;

import com.ta.crud.Role.Entity.Role;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private boolean status;

    private String password;

    @Column(unique = true, nullable = false)
    private long mobileNumber;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public User(String firstName, String lastName, String email, Role role, boolean status, String password,
            long mobileNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.role = role;
        this.password = password;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    public User(){}
}
