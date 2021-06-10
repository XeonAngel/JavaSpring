package com.example.JavaSpringProject.models;

import com.example.JavaSpringProject.models.Enums.Drug_Category;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@ToString(onlyExplicitlyIncluded = true)
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(message = "No more than 200 characters", max = 200)
    @NotNull(message = "Drug name is required")
    private String name;

    @NotNull(message = "Drug category is required")
    private Drug_Category drugCategory;

    @Min(message = "No negative value for price", value = 0)
    private float price;

    @Min(message = "No negative value for stock", value = 0)
    private int stock;

    @ManyToMany(mappedBy = "drugs")
    private List<Consultation> consultations;

    @NotNull(message = "Distributor is required")
    @ManyToOne
    private Distributor distributor;
}
