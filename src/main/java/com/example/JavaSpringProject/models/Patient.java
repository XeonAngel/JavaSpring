package com.example.JavaSpringProject.models;

import com.example.JavaSpringProject.models.Enums.BloodType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(onlyExplicitlyIncluded = true)
public class Patient extends Person {
    private BloodType bloodType;

    @OneToMany(mappedBy = "patient")
    private List<Consultation> consultationList;
}