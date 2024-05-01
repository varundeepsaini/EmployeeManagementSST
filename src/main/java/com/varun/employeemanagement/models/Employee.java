package com.varun.employeemanagement.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", updatable = false)  // Prevent updates
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", updatable = false)  // Prevent updates
    private Role role;

    private Date dateOfJoining;
}
