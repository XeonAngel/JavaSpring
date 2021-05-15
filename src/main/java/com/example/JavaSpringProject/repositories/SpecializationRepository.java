package com.example.JavaSpringProject.repositories;

import com.example.JavaSpringProject.models.Specialization;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecializationRepository extends BaseRepository<Specialization> {
    List<Specialization> findByNameLike(String name);
}
