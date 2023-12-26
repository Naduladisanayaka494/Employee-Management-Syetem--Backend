package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")

    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
       EmployeeDto employeeDto =employeeService.getEmployeeId(employeeId);
        return ResponseEntity.ok(employeeDto);
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDto >>getAllEmployees(){
        List<EmployeeDto> employees=employeeService.getAllemployees();
        return ResponseEntity.ok(employees);
    }


    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updatedEmployee(@PathVariable("id") Long employeeId,@RequestBody  EmployeeDto updatedEmployee){
        EmployeeDto employeeDto= employeeService.updatedEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }
}