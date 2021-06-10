package com.example.JavaSpringProject.models;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;

    @NotNull(message = "Doctor is required")
    @ManyToOne
    private Employee doctor;

    @NotNull(message = "Patient is required")
    @ManyToOne
    private Patient patient;

    @ManyToMany
    @JoinTable(name = "consultation_drug",
    joinColumns = @JoinColumn(name = "consultation_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "drug_id",referencedColumnName = "id"))
    private List<Drug> drugs;
}
