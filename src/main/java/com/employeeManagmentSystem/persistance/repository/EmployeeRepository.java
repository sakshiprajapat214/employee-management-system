package com.employeeManagmentSystem.persistance.repository;

import com.employeeManagmentSystem.persistance.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
