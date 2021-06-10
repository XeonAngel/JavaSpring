package com.example.JavaSpringProject.services;

import com.example.JavaSpringProject.exceptions.ResourceNotFoundException;
import com.example.JavaSpringProject.models.Occupation;
import com.example.JavaSpringProject.repositories.OccupationRepository;
import com.example.JavaSpringProject.services.interfaces.IOccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class OccupationService implements IOccupationService {
    OccupationRepository occupationRepository;

    @Autowired
    public OccupationService(OccupationRepository occupationRepository) {
        this.occupationRepository = occupationRepository;
    }

    @Override
    public List<Occupation> findAll() {
        List<Occupation> occupations = new LinkedList<>();
        occupationRepository.findAll().iterator().forEachRemaining(occupations::add);
        return occupations;
    }

    @Override
    public Occupation findById(Long Id) {
        Optional<Occupation> optionalOccupation = occupationRepository.findById(Id);
        if (optionalOccupation.isEmpty()) {
            throw new ResourceNotFoundException("Occupation " + Id + " not found!");
        }
        return optionalOccupation.get();
    }

    @Override
    public Occupation save(Occupation entity) {
        return occupationRepository.save(entity);
    }

    @Override
    public void deleteById(Long Id) {
        Optional<Occupation> optionalOccupation = occupationRepository.findById(Id);
        if (optionalOccupation.isEmpty()) {
            throw new ResourceNotFoundException("Occupation " + Id + " not found!");
        }
        occupationRepository.deleteById(Id);
    }
}
