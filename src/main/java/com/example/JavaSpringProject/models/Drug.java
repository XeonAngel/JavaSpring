package com.example.JavaSpringProject.models;

import com.example.JavaSpringProject.models.Enums.Drug_Category;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Drug_Category drugCategory;

    private float price;

    private int stock;

    @ManyToMany(mappedBy = "drugs")
    private List<Consultation> consultations;

    @ManyToOne
    private Distributor distributor;
}
