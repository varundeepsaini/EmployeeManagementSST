package com.varun.app.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    private Long id;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")  // Adds foreign key column to Employee table
    private Department department;

    @ManyToOne
    @JoinColumn(name = "role_id")  // Adds foreign key column to Employee table
    private Role role;

    private Date dateOfJoining;
    private Boolean isAdmin;
}
