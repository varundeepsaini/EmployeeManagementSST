package com.varun.employeemanagement.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
@Entity
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;

    @OneToMany(mappedBy = "role")
    private Set<Employee> employees;

}
