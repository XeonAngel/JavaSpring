package com.example.JavaSpringProject.models;

import lombok.Data;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@Data
public class Person {
    private Long Id;
    private String FirstName;
    private String LastName;
    private LocalDate BirthDay;

    public String getFullName(){
        return FirstName + " " + LastName;
    }
}
