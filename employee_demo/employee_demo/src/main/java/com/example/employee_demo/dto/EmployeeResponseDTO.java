package com.example.employee_demo.dto;

import com.example.employee_demo.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeResponseDTO {

        private Long id;
        private String name;

        private String email;

        public EmployeeResponseDTO(Employee employee) {
            this.id = employee.getId();
            this.name = employee.getName();
            this.email = employee.getEmail();
        }



}
