package com.example.JavaSpringProject.models;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "distributor")
    private List<Drug> DrugList;
}
