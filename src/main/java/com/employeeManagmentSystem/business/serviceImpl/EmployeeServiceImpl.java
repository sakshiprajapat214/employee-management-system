package com.employeeManagmentSystem.business.serviceImpl;

import com.employeeManagmentSystem.api.dto.EmployeeDto;
import com.employeeManagmentSystem.business.service.EmployeeService;
import com.employeeManagmentSystem.handler.ResourceNotFoundException;
import com.employeeManagmentSystem.persistance.entity.Employee;
import com.employeeManagmentSystem.persistance.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> result = new ArrayList<>();
        for (Employee emp : employees) {
            result.add(modelMapper.map(emp, EmployeeDto.class));
        }
        return result;

    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not found with id: " + id));
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto dto) {
        Employee employee = modelMapper.map(dto, Employee.class);
        return modelMapper.map(employeeRepository.save(employee), EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {
        Employee emp = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not found"));

        emp.setFirstName(dto.getFirstName());
        emp.setLastName(dto.getLastName());
        emp.setEmail(dto.getEmail());
        emp.setDepartment(dto.getDepartment());

        return modelMapper.map(employeeRepository.save(emp), EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
