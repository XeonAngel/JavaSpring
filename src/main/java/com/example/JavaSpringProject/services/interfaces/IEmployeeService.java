package com.example.JavaSpringProject.services.interfaces;

import com.example.JavaSpringProject.models.Employee;

import java.util.List;

public interface IEmployeeService extends BaseService<Employee> {
    List<Employee> findAllMedicalStaff();
}
