package com.example.JavaSpringProject.models;

import com.example.JavaSpringProject.models.Enums.Rank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = false)
@Data
public class Staff extends Person {
    private Rank staffRank;

    @ManyToOne
    private Occupation occupation;

    @ManyToOne
    private Specialization specialization;

    @OneToOne
    private Department managedDepartment;

    @OneToMany(mappedBy = "doctor")
    private List<Consultation> consultationList;
}