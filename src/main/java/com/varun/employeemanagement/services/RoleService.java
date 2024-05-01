package com.varun.employeemanagement.services;

import com.varun.employeemanagement.models.Role;
import com.varun.employeemanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    public Role updateRole(Long id , Role roleDetails){


        Optional<Role> roleoptional = roleRepository.findById(id);


        if (roleoptional.isPresent()) {
            Role existingRole = roleoptional.get();

            existingRole.setRoleName(roleDetails.getRoleName());
            existingRole.setEmployees(roleDetails.getEmployees());

            return roleRepository.save(existingRole);
        }
        return null;
    }
}
