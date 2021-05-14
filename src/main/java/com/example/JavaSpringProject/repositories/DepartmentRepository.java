package com.example.JavaSpringProject.repositories;

import com.example.JavaSpringProject.models.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends BaseRepository<Department>{
    List<Department> findByNameLike(String name);
}
