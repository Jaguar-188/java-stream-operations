package com.streams.demo.controller;

import com.streams.demo.entity.Employee;
import com.streams.demo.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/employee-controller")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/getAllEmployees")
    public List<Employee> getAllEmployees(){

        return employeeService.getAllEmployees();
    }

    @PostMapping(value = "/addEmployee")
    @Operation(description = "It adds the new employee record/document to the collection.",
            method = "POST",
            responses = {@ApiResponse(responseCode = "201", description = "Created", content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Server side problem", content = @Content(mediaType = "application/json"))})
    public Employee addEmployee(@RequestBody Employee employee){

        return employeeService.addEmployee(employee);
    }

    @GetMapping(value = "/getEmployeesWithMinimumSalary")
    public String getEmployeesWithMinimumSalary(){

        return String.valueOf(employeeService.getEmployeesWithMinimumSalary());
    }

    @GetMapping(value = "/getEmployeesWithMaximumSalary")
    public String getEmployeesWithMaximumSalary(){

        return String.valueOf(employeeService.getEmployeesWithMaximumSalary());
    }

    @GetMapping(value = "/getEmployeesWithSecondMaximumSalary")
    public String getEmployeesWithSecondMaximumSalary(){

        return String.valueOf(employeeService.getEmployeesWithSecondMaximumSalary());
    }

    @GetMapping(value = "/getEmployeeNameWithMaximumSalary")
    public List<Employee> getEmployeeNameWithMaximumSalary(){

        return employeeService.getEmployeeNameWithMaximumSalary();
    }

    @GetMapping(value = "/getEmployeeNameWithSecondMaximumSalary")
    public List<Employee> getEmployeeNameWithSecondMaximumSalary(){

        return employeeService.getEmployeeNameWithSecondMaximumSalary();
    }

    @GetMapping(value = "/getEmployeeNameWithSalaryGreaterThan5000")
    public List<Employee> getEmployeeNameWithSalaryGreaterThan5000(){

        return employeeService.getEmployeeNameWithSalaryGreaterThan5000();
    }

    @GetMapping(value = "/getDepartmentWiseEmployeeList")
    public Map<Integer,List<Employee>> getDepartmentWiseEmployeeList(){

        return employeeService.getDepartmentWiseEmployeeList();
    }

}
