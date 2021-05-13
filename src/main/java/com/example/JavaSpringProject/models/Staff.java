package com.example.JavaSpringProject.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;

@Entity
@EqualsAndHashCode(callSuper = false)
@Data
public class Staff extends Person {
    private Ranks Staff_Rank;
}
