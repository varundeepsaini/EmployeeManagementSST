package com.varun.app.service;

import com.varun.app.models.Employee;
import com.varun.app.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails, Long updaterId) {
        Employee existingEmployee = employeeRepo.findById(id).orElse(null);
        Employee updater = employeeRepo.findById(updaterId).orElse(null);

        if(updater == null){
            return null;
        }

        if(updater.getIsAdmin()){
            if (existingEmployee != null) {
                existingEmployee.setName(employeeDetails.getName());
                existingEmployee.setRole(employeeDetails.getRole());
                existingEmployee.setDepartment(employeeDetails.getDepartment());
                existingEmployee.setIsAdmin(employeeDetails.getIsAdmin());
                return employeeRepo.save(existingEmployee);
            }
        }else{
            if (existingEmployee != null) {
                existingEmployee.setName(employeeDetails.getName());
                existingEmployee.setEmail(employeeDetails.getEmail());
                return employeeRepo.save(existingEmployee);
            }
        }
        return null;
    }

    public String deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
        return "Employee deleted successfully";
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();}
}
