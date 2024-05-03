package com.varun.app.service;

import com.varun.app.models.Employee;
import com.varun.app.repo.DepartmentRepo;
import com.varun.app.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.varun.app.models.Department;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public Department saveDepartment(Department department, Long assignerId) {
        Employee assigner = employeeRepo.findById(assignerId).orElse(null);

        if(assigner == null){
            return null;
        }

        if(assigner.getIsAdmin()){
            return departmentRepo.save(department);
        }else {
            return null;
        }
    }

    public List<Employee> getEmployeesByDepartment(Long id) {
        return departmentRepo.getEmployeesByDepartment(id);
    }

    public Department getDepartmentById(Long id) {
        return departmentRepo.findById(id).orElse(null);
    }

    public Department updateDepartment(Long id, Department departmentDetails, Long assignerId) {
        Department existingDepartment = departmentRepo.findById(id).orElse(null);
        Employee assigner = employeeRepo.findById(assignerId).orElse(null);

        if(assigner == null){
            return null;
        }

        if(assigner.getIsAdmin()){
            if (existingDepartment != null) {
                existingDepartment.setName(departmentDetails.getName());
                return departmentRepo.save(existingDepartment);
            }
        }
        return null;
    }

    public Department deleteDepartment(Long id, Long assignerId) {
        Department existingDepartment = departmentRepo.findById(id).orElse(null);
        Employee assigner = employeeRepo.findById(assignerId).orElse(null);

        if(assigner == null){
            return null;
        }

        if(assigner.getIsAdmin()){
            if (existingDepartment != null) {
                departmentRepo.deleteById(id);
                return existingDepartment;
            }
        }
        return null;
    }

}
