package com.example.JavaSpringProject.services;

import com.example.JavaSpringProject.models.Department;
import com.example.JavaSpringProject.repositories.DepartmentRepository;
import com.example.JavaSpringProject.services.interfaces.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {
    DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> findAll() {
        List<Department> departments = new LinkedList<>();
        departmentRepository.findAll().iterator().forEachRemaining(departments::add);
        return departments;
    }

    @Override
    public Department findById(Long Id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(Id);
        if (optionalDepartment.isEmpty()) {
            throw new RuntimeException("Department not found!");
        }
        return optionalDepartment.get();
    }

    @Override
    public Department save(Department entity) {
        return departmentRepository.save(entity);
    }

    @Override
    public void deleteById(Long Id) {
        departmentRepository.deleteById(Id);
    }
}
