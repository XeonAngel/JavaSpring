package com.example.JavaSpringProject.repositories;

import com.example.JavaSpringProject.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee> {
    List<Employee> findByLastNameLike(String lastName);
    List<Employee> findBySpecializationId(Long specializationId);
}
