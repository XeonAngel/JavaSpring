package com.example.JavaSpringProject.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class Patient extends Person {
    private BloodType bloodType;
}
