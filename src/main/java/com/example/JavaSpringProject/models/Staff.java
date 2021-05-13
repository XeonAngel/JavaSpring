package com.example.JavaSpringProject.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class Staff extends Person {
    private Ranks ranks;
}
