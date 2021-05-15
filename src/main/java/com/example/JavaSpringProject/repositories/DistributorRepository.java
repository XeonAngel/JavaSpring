package com.example.JavaSpringProject.repositories;

import com.example.JavaSpringProject.models.Distributor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributorRepository extends BaseRepository<Distributor>{
    List<Distributor> findByNameLike(String name);
}
