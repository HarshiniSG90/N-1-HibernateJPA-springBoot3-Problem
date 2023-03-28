package com.hsbc.codingchallenge.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String companyName;
    private String address;

    @OneToMany(targetEntity = Employee.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="employer_id_fk",referencedColumnName = "id")
    private Set<Employee> employeeList;
}
