package com.example.JavaSpringProject.repositories;

import com.example.JavaSpringProject.models.Consultation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultationRepository extends BaseRepository<Consultation>{
    List<Consultation> findByPatientFirstName(String name);
}
