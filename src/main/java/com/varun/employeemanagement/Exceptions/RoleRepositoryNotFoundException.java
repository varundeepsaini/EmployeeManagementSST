package com.varun.employeemanagement.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRepositoryNotFoundException extends  RuntimeException {
    private Long id;
    public RoleRepositoryNotFoundException(Long id){
        super("Role not found with id: "+id);
        this.id = id;
    }
}
