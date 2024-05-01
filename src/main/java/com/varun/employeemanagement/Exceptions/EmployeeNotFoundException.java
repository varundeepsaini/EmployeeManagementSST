package com.varun.employeemanagement.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeNotFoundException  extends  RuntimeException{
    private Long id;
    public EmployeeNotFoundException(Long id){
        super("Employee not found with id: "+id);
        this.id = id;
    }
}
