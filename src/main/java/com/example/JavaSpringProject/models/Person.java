package com.example.JavaSpringProject.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@MappedSuperclass
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(message = "No more than 200 characters", max = 200)
    @NotNull(message = "Firstname is required")
    private String firstName;

    @Size(message = "No more than 200 characters", max = 200)
    @NotNull(message = "Lastname is required")
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    public String getFullName(){
        return firstName + " " + lastName;
    }
}