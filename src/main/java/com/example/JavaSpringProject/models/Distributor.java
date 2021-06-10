package com.example.JavaSpringProject.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(message = "No more than 200 characters", max = 200)
    @NotEmpty(message = "Distributor name is required")
    @NotNull(message = "Distributor name is required")
    private String name;

    @OneToMany(mappedBy = "distributor")
    private List<Drug> DrugList;
}
