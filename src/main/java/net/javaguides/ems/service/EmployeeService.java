package net.javaguides.ems.service;

import net.javaguides.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeId(Long employeeId);
    List<EmployeeDto> getAllemployees();
    EmployeeDto updatedEmployee(Long EmployeeId,EmployeeDto updatedEmployee);

}
