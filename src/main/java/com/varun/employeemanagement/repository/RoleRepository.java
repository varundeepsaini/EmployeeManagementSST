package com.varun.employeemanagement.repository;

import com.varun.employeemanagement.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

