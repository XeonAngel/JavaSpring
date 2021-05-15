package com.example.JavaSpringProject.repositories;

import com.example.JavaSpringProject.models.Occupation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OccupationRepository  extends BaseRepository<Occupation>{
    List<Occupation> findByNameLike(String name);
}
