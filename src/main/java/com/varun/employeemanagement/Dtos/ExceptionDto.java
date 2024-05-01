package com.varun.employeemanagement.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDto {
    private String message;
    private Long id;

        public ExceptionDto(String message, Long id) {
            this.message = message;
            this.id = id;
        }

        public ExceptionDto(String message) {
            this.message = message;
        }
}
