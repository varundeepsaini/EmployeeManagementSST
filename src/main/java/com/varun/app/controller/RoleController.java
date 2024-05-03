package com.varun.app.controller;

import com.varun.app.models.Employee;
import com.varun.app.models.Role;
import com.varun.app.service.RoleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByRole(@PathVariable Long id) {
        return roleService.getEmployeesByRole(id);
    }

    @PutMapping("/{roleId}/employees/{employeeId}")
    public String assignRoleToEmployee(@PathVariable Long roleId, @PathVariable Long employeeId, @RequestParam Long assignerId) {
        return roleService.assignRoleToEmployee(roleId, employeeId, assignerId);
    }

}
