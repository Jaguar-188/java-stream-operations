package com.streams.demo.serviceImpl;

import com.streams.demo.entity.Employee;
import com.streams.demo.repository.EmployeeRepository;
import com.streams.demo.service.EmployeeService;
import com.streams.demo.utils.ComparatorHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        System.out.println("Fetching data");
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public int getEmployeesWithMinimumSalary() {
        return  employeeRepository.findAll()
                .stream()
                .mapToInt(Employee::getSalary)
                .distinct()
                .min()
                .getAsInt();
    }

    @Override
    public int getEmployeesWithMaximumSalary() {

        return employeeRepository.findAll()
                .stream()
                .map(Employee::getSalary).toList()
                .stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .findFirst()
                .get();
    }

    @Override
    public int getEmployeesWithSecondMaximumSalary() {

        return employeeRepository.findAll()
                .stream()
                .map(Employee::getSalary)
                .toList()
                .stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .get();
    }

    @Override
    public List<Employee> getEmployeeNameWithMaximumSalary() {

        return employeeRepository.findAll()
                .stream()
                .max(Comparator.comparing(Employee::getSalary))
                .stream()
                .toList();
    }

    @Override
    public List<Employee> getEmployeeNameWithSecondMaximumSalary() {

        return employeeRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .distinct()
                .skip(1)
                .findFirst()
                .stream().toList();
    }

    @Override
    public List<Employee> getEmployeeNameWithSalaryGreaterThan5000() {

        return employeeRepository.findAll()
                .stream()
                .filter(employee -> employee.getSalary() > 5000)
                .distinct()
                .limit(100)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getDepartmentWiseEmployeeList() {

        return employeeRepository.findAll()
                .stream()
                .limit(10)
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.toList()));
    }

    @Override
    public List<Employee> getEmployeesSortedBySalaryUsingComparator() {

        Pageable pageable = PageRequest.of(0,100);

        List<Employee> employeeList = new ArrayList<>(employeeRepository.findAll(pageable).getContent());

        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if(e1.getSalary() < e2.getSalary())
                {
                    return -1;
                } else if (e1.getSalary() == e2.getSalary()) {
                    return 0;
                }
                else
                {
                    return 1;
                }
            }
        });
        return employeeList;
    }

//    @Override
//    public Map<Integer, Integer> getDepartmentWiseMaximumSalary() {
//
//        return employeeRepository.findAll()
//                .stream()
//                .map()
//                .collect(Collectors.groupingBy(Employee::getDepartment))
//    }
}
