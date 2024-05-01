package com.varun.employeemanagement.repository;

import com.varun.employeemanagement.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
