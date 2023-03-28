package com.hsbc.codingchallenge.controller;

import com.hsbc.codingchallenge.dto.APIResponse;
import com.hsbc.codingchallenge.entity.Employee;
import com.hsbc.codingchallenge.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> fetchAllEmployee()
    {
        List<Employee> list = employeeService.fetchAllEmployee();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<APIResponse> saveEmployee(@RequestBody @Valid Employee employee)
    {
        Employee list = employeeService.saveEmployee(employee);
        APIResponse response = APIResponse.builder().status("SUCCESS")
                .results(list).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
