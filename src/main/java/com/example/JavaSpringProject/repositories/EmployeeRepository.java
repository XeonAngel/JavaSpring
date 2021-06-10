package com.example.JavaSpringProject.repositories;

import com.example.JavaSpringProject.models.Employee;
import com.example.JavaSpringProject.models.Occupation;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee> {
    List<Employee> findByLastNameLike(String lastName);
    List<Employee> findBySpecializationId(Long specializationId);
    List<Employee> findByOccupationNameIn(Collection<String> occupation_name_list);
}
