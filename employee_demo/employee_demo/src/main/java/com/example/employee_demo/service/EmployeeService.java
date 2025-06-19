package com.example.employee_demo.service;

import com.example.employee_demo.dto.EmployeeRequestDTO;
import com.example.employee_demo.dto.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto);

    List<EmployeeResponseDTO> getAllEmployeeDetails();

    EmployeeResponseDTO getEmployeeDetailsById(Long id);

    EmployeeResponseDTO updateEmployeeDetails(Long id, EmployeeRequestDTO request);

    String deleteEmployeeDetails(Long id);

}
