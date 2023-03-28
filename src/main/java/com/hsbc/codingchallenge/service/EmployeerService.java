package com.hsbc.codingchallenge.service;

import com.hsbc.codingchallenge.dao.EmployeerRepository;
import com.hsbc.codingchallenge.entity.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeerService {

    @Autowired
    private EmployeerRepository employeerRepository;

    public List<Employer> fetchEmployeer() {
        return employeerRepository.findEmployeerWithAllEmployees();
    }

    public Employer save(Employer employer) {
        return employeerRepository.save(employer);
    }
}
