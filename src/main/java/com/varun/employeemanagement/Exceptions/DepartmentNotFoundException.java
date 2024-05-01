package com.varun.employeemanagement.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentNotFoundException extends RuntimeException {

    private Long id;
    public DepartmentNotFoundException(Long id){
        super("Department not found with id: "+id);
        this.id = id;
    }
}
