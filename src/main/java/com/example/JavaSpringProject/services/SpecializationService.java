package com.example.JavaSpringProject.services;

import com.example.JavaSpringProject.models.Specialization;
import com.example.JavaSpringProject.repositories.SpecializationRepository;
import com.example.JavaSpringProject.services.interfaces.ISpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class SpecializationService implements ISpecializationService {
    SpecializationRepository specializationRepository;

    @Autowired
    public SpecializationService(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    @Override
    public List<Specialization> findAll() {
        List<Specialization> specializations = new LinkedList<>();
        specializationRepository.findAll().iterator().forEachRemaining(specializations::add);
        return specializations;
    }

    @Override
    public Specialization findById(Long Id) {
        Optional<Specialization> optionalSpecialization = specializationRepository.findById(Id);
        if (optionalSpecialization.isEmpty()) {
            throw new RuntimeException("Specialization not found!");
        }
        return optionalSpecialization.get();
    }

    @Override
    public Specialization save(Specialization entity) {
        return specializationRepository.save(entity);
    }

    @Override
    public void deleteById(Long Id) {
        specializationRepository.deleteById(Id);
    }
}
