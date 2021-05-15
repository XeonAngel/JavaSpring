package com.example.JavaSpringProject.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;

    @ManyToOne
    private Employee doctor;

    @ManyToOne
    private Patient patient;

    @ManyToMany
    @JoinTable(name = "consultation_drug",
    joinColumns = @JoinColumn(name = "consultation_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "drug_id",referencedColumnName = "id"))
    private List<Drug> drugs;
}
