package com.example.JavaSpringProject.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(message = "No more than 200 characters", max = 200)
    @NotNull(message = "Occupation name is required")
    @NotEmpty(message = "Occupation name is required")
    private String name;

    @Min(message = "No negative value for salary", value = 0)
    private int baseSalary;

    @OneToMany(mappedBy = "occupation")
    private List<Employee> employeeList;
}