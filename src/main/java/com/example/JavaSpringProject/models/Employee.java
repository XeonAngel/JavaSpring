package com.example.JavaSpringProject.models;

import com.example.JavaSpringProject.models.Enums.Rank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(onlyExplicitlyIncluded = true)
public class Employee extends Person {
    private Rank employeeRank;

    @ManyToOne
    private Occupation occupation;

    @ManyToOne
    private Specialization specialization;

    @OneToOne
    private Department managedDepartment;

    @OneToMany(mappedBy = "doctor")
    private List<Consultation> consultationList;
}