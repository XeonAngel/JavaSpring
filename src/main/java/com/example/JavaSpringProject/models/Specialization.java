package com.example.JavaSpringProject.models;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
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
