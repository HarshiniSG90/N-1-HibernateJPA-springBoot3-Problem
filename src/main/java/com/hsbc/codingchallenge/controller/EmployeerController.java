package com.hsbc.codingchallenge.controller;

import com.hsbc.codingchallenge.dto.APIResponse;
import com.hsbc.codingchallenge.entity.Employer;
import com.hsbc.codingchallenge.service.EmployeeService;
import com.hsbc.codingchallenge.service.EmployeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeerController {
    @Autowired
    private EmployeerService employeerService;

    @GetMapping("/employeer/all")
    public ResponseEntity<APIResponse> fetchEmployeer()
    {
        List<Employer> employerList = employeerService.fetchEmployeer();
        APIResponse<Object> apiResponse = APIResponse.builder()
                .status("SUCESS").results(employerList).build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/employeer/save")
    public ResponseEntity<APIResponse> saveAllEmployeer(@RequestBody Employer employer)
    {
       Employer emp = employeerService.save(employer);
       APIResponse<Object> response = APIResponse.builder()
               .status("Success")
               .results(emp)
               .build();
       return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
