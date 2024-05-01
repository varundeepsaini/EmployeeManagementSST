package com.varun.employeemanagement.GlobalControllerAdvice;

import com.varun.employeemanagement.Dtos.ExceptionDto;
import com.varun.employeemanagement.Exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.management.relation.RoleNotFoundException;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(DuplicateRecordException.class)
    public ResponseEntity<ExceptionDto> handleDuplicateRecordException(DuplicateRecordException exp) {
        ExceptionDto dto = new ExceptionDto("Duplicate record! This record already exists: " + exp.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleEmployeeNotFoundException(EmployeeNotFoundException exp) {
        ExceptionDto dto = new ExceptionDto("Employee not found with id: " + exp.getId());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleDepartmentNotFoundException(DepartmentNotFoundException exp) {
        ExceptionDto dto = new ExceptionDto("Department not found with id: " + exp.getId());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleRoleNotFoundException(RoleNotFoundException exp) {
        ExceptionDto dto = new ExceptionDto("Role not found: " + exp.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}