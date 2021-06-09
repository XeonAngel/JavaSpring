package com.example.JavaSpringProject.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "specialization")
    private List<Employee> employeeList;

    @ManyToOne
    private Department department;
}
