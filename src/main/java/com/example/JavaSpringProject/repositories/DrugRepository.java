package com.example.JavaSpringProject.repositories;

import com.example.JavaSpringProject.models.Drug;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugRepository extends BaseRepository<Drug>{
    List<Drug> findByNameLike(String name);
}
