package com.example.JavaSpringProject.models;

import com.example.JavaSpringProject.models.Enums.BloodType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = false)
@Data
public class Patient extends Person {
    private BloodType bloodType;

    @OneToMany(mappedBy = "patient")
    private List<Consultation> consultationList;
}