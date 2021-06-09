package com.example.JavaSpringProject.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department")
    private List<Specialization> specializationList;

    @OneToOne(mappedBy = "managedDepartment")
    private Employee departmentManager;
}
