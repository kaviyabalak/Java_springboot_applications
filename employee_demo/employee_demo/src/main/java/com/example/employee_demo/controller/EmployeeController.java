package com.example.employee_demo.controller;

import com.example.employee_demo.dto.EmployeeRequestDTO;
import com.example.employee_demo.dto.EmployeeResponseDTO;
import com.example.employee_demo.model.Employee;
import com.example.employee_demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeResponseDTO> createEmployeeDetails(@Valid @RequestBody EmployeeRequestDTO dto){
    EmployeeResponseDTO saveEmployee = employeeService.createEmployee(dto);
    return ResponseEntity.status(201).body(saveEmployee);
    }

    @GetMapping("/listAllEmployees")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployeeDetails(){
        return ResponseEntity.ok(employeeService.getAllEmployeeDetails());
    }

    @GetMapping("/getEmployeeDetailsById/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeDetailsById(id));
    }

    @PutMapping("/updateEmployeeDetails/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployeeDetails(@PathVariable Long id, @Valid @RequestBody EmployeeRequestDTO dto){
        return ResponseEntity.ok(employeeService.updateEmployeeDetails(id,dto));
    }

    @DeleteMapping("/deleteEmployeeDetails/{id}")
    public ResponseEntity<String> deleteEmployeeDetails(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.deleteEmployeeDetails(id));
    }

}
