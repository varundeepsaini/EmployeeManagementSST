package com.varun.employeemanagement.services;

import com.varun.employeemanagement.models.Department;
import com.varun.employeemanagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department updateDepartment(Long id , Department departmentDetails){

        Optional<Department> departmentoptional = departmentRepository.findById(id);

        if (departmentoptional.isPresent()) {
            Department existingDepartment = departmentoptional.get();
            existingDepartment.setName(departmentDetails.getName());
            existingDepartment.setDescription(departmentDetails.getDescription());
            existingDepartment.setEmployees(departmentDetails.getEmployees());

            return departmentRepository.save(existingDepartment);
        }
        return null;
    }
}
