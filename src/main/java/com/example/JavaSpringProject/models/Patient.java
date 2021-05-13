package com.example.JavaSpringProject.models;

import com.example.JavaSpringProject.models.Enums.BloodType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;

@Entity
@EqualsAndHashCode(callSuper = false)
@Data
public class Patient extends Person {
    private BloodType bloodType;
}