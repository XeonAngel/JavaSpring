package com.example.JavaSpringProject.models;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate created;

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
