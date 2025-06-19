package com.example.employee_demo.service;

import com.example.employee_demo.dto.EmployeeRequestDTO;
import com.example.employee_demo.dto.EmployeeResponseDTO;
import com.example.employee_demo.model.Employee;
import com.example.employee_demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {
       Employee employee = new Employee(dto.getName(),dto.getEmail());
       Employee savedEmployeeDetails =  employeeRepository.save(employee);
       return new EmployeeResponseDTO(savedEmployeeDetails);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployeeDetails() {
        List<EmployeeResponseDTO> getAllEmpDetails =  employeeRepository.findAll().stream().
                map(employee -> new EmployeeResponseDTO(employee))
                .collect(Collectors.toList());
        return getAllEmpDetails;
    }

    @Override
    public EmployeeResponseDTO getEmployeeDetailsById(Long id) {
        Employee employeeDetails =  employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found for this id" + id));
        return new EmployeeResponseDTO(employeeDetails);
    }

    @Override
    public EmployeeResponseDTO updateEmployeeDetails(Long id, EmployeeRequestDTO request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found " + id));
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        Employee updated = employeeRepository.save(employee);
        return new EmployeeResponseDTO(updated);
    }

    @Override
    public String deleteEmployeeDetails(Long id) {
        Employee employee = employeeRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id not found" + id));
        employeeRepository.delete(employee);
        return "Employee Record deleted successfully";
    }


}
