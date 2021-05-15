package com.example.JavaSpringProject.repositories;

import com.example.JavaSpringProject.models.Patient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends BaseRepository<Patient>{
    List<Patient> findByLastNameLike(String name);
}
