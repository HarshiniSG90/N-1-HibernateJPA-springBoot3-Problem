package com.hsbc.codingchallenge.dao;

import com.hsbc.codingchallenge.entity.Employer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeerRepository extends JpaRepository<Employer,Integer> {

    @EntityGraph(attributePaths = {"employeeList"})
    List<Employer> findAll();

    @Query("select p from Employer p LEFT JOIN FETCH p.employeeList")
    List<Employer> findEmployeerWithAllEmployees();
}
