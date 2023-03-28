package com.hsbc.codingchallenge.service;

import com.hsbc.codingchallenge.dao.EmployeeRepository;
import com.hsbc.codingchallenge.entity.Employee;
import com.hsbc.codingchallenge.entity.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> fetchAllEmployee() {
        List<Employee> list = employeeRepository.findAll();
        return list;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


}
