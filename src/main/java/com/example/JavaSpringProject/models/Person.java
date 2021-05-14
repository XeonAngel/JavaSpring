package com.example.JavaSpringProject.models;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    private LocalDate birthDay;

    public String getFullName(){
        return firstName + " " + lastName;
    }
}