package net.javaguides.ems.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repository.EmployeeeRepository;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceimpl implements EmployeeService {
    private EmployeeeRepository employeeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeId(Long employeeId) {
        Employee employee=employeeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("employee is not exsiys with given id"+employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllemployees() {
      List<Employee> employees=employeeeRepository.findAll();
      return employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updatedEmployee(Long EmployeeId, EmployeeDto updatedEmployee) {
        Employee employee=employeeeRepository.findById(EmployeeId).orElseThrow(()-> new ResourceNotFoundException("Employee is not found"+EmployeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        employeeeRepository.save(employee);
        Employee updatedEmployeeobj=employeeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeobj);

    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=employeeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee is not found"+employeeId));
        employeeeRepository.deleteById(employeeId);
    }
}
