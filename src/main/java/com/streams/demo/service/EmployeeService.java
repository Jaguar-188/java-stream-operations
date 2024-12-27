package com.streams.demo.service;

import com.streams.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {


    List<Employee> getAllEmployees();

    Employee addEmployee(Employee employee);

    int getEmployeesWithMinimumSalary();

    int getEmployeesWithMaximumSalary();

    int getEmployeesWithSecondMaximumSalary();

    List<Employee> getEmployeeNameWithMaximumSalary();
}
