package com.varun.employeemanagement.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
@Entity
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;
}
