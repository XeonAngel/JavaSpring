package com.example.JavaSpringProject.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Department name is required")
    @NotNull(message = "Department name is required")
    @Size(message = "No more than 200 characters", max = 200)
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Specialization> specializationList;

    @OneToOne(mappedBy = "managedDepartment")
    private Employee departmentManager;
}
