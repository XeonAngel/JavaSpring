package com.example.JavaSpringProject.repositories;

import com.example.JavaSpringProject.models.Department;
import java.util.List;

public interface DepartmentRepository extends BaseRepository<Department>{
    List<Department> findByNameLike(String name);
}
