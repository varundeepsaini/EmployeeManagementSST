package com.varun.app.repo;

import com.varun.app.models.Department;
import com.varun.app.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

    @Query("SELECT e FROM Employee e WHERE e.department.id = ?1")
    public List<Employee> getEmployeesByDepartment(Long id);

}
