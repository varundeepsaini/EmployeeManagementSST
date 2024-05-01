package com.varun.employeemanagement.repository;

import com.varun.employeemanagement.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

