package com.example.JavaSpringProject.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(message = "No more than 200 characters", max = 200)
    @NotNull(message = "Specialization name is required")
    private String name;

    @OneToMany(mappedBy = "specialization")
    private List<Employee> employeeList;

    @NotNull(message = "Department is required")
    @ManyToOne
    private Department department;
}
