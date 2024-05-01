package com.varun.employeemanagement.services;

import com.varun.employeemanagement.models.Employee;
import com.varun.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id , Employee employeeDetails){

        Optional<Employee> employeeoptional = employeeRepository.findById(id);

        if (employeeoptional.isPresent()) {
            Employee existingEmployee = employeeoptional.get();

            existingEmployee.setName(employeeDetails.getName());
            existingEmployee.setEmail(employeeDetails.getEmail());
            existingEmployee.setDepartment(employeeDetails.getDepartment());
            existingEmployee.setRole(employeeDetails.getRole());
            existingEmployee.setDateOfJoining(employeeDetails.getDateOfJoining());

            return employeeRepository.save(existingEmployee);
        }
        return null;
    }
}
