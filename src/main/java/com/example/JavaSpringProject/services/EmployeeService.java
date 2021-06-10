package com.example.JavaSpringProject.services;

import com.example.JavaSpringProject.exceptions.ResourceNotFoundException;
import com.example.JavaSpringProject.models.Employee;
import com.example.JavaSpringProject.repositories.EmployeeRepository;
import com.example.JavaSpringProject.services.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new LinkedList<>();
        employeeRepository.findAll().iterator().forEachRemaining(employees::add);
        return employees;
    }

    @Override
    public Employee findById(Long Id) {
        Optional<Employee> optionalStaff = employeeRepository.findById(Id);
        if (optionalStaff.isEmpty()) {
            throw new ResourceNotFoundException("Employee " + Id + " not found!");
        }
        return optionalStaff.get();
    }

    @Override
    public Employee save(Employee entity) {
        return employeeRepository.save(entity);
    }

    @Override
    public void deleteById(Long Id) {
        Optional<Employee> optionalStaff = employeeRepository.findById(Id);
        if (optionalStaff.isEmpty()) {
            throw new ResourceNotFoundException("Employee " + Id + " not found!");
        }
        employeeRepository.deleteById(Id);
    }
}
