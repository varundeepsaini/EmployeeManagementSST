package com.varun.app.service;


import com.varun.app.models.Employee;
import com.varun.app.models.Role;
import com.varun.app.repo.RoleRepo;
import com.varun.app.repo.EmployeeRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    public List<Employee> getEmployeesByRole(Long id) {
        return roleRepo.getEmployeesByRole(id);
    }

    public String assignRoleToEmployee(Long roleId, Long employeeId, Long assignerId) {
        Role role = roleRepo.findById(roleId).orElse(null);
        Employee employee = employeeRepo.findById(employeeId).orElse(null);
        Employee assigner = employeeRepo.findById(assignerId).orElse(null);

        if(assigner == null){
            return "Assigner not found";
        }

        if(assigner.getIsAdmin()){
            if(role != null && employee != null){
                employee.setRole(role);
                employeeRepo.save(employee);
                return "Role assigned successfully to employee with id: " + employeeId + " by assigner with id: " + assignerId;
            }
            if (role == null){
                return "Role not found";
            }
            return "Employee not found";

        }else {
            return "You are not authorized to assign roles";
        }
    }



}
