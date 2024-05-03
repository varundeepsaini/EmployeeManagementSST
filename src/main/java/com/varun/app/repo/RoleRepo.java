package com.varun.app.repo;

import com.varun.app.models.Employee;
import com.varun.app.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    @Query("SELECT e FROM Employee e WHERE e.role.id = ?1")
    public List<Employee> getEmployeesByRole(Long id);

}
