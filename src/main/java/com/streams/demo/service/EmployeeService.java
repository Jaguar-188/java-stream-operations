package com.streams.demo.service;

import com.streams.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface EmployeeService {


    List<Employee> getAllEmployees();

    Employee addEmployee(Employee employee);

    int getEmployeesWithMinimumSalary();

    int getEmployeesWithMaximumSalary();

    int getEmployeesWithSecondMaximumSalary();

    List<Employee> getEmployeeNameWithMaximumSalary();

    List<Employee> getEmployeeNameWithSecondMaximumSalary();

    List<Employee> getEmployeeNameWithSalaryGreaterThan5000();

    Map<Integer,List<Employee>> getDepartmentWiseEmployeeList();

//    Map<Integer, Integer> getDepartmentWiseMaximumSalary();
}
