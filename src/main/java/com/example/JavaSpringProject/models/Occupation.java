package com.example.JavaSpringProject.models;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int baseSalary;

    @OneToMany(mappedBy = "occupation")
    private List<Staff> staffList;
}