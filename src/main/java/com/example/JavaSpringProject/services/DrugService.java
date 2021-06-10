package com.example.JavaSpringProject.services;

import com.example.JavaSpringProject.exceptions.ResourceNotFoundException;
import com.example.JavaSpringProject.models.Drug;
import com.example.JavaSpringProject.repositories.DrugRepository;
import com.example.JavaSpringProject.services.interfaces.IDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DrugService implements IDrugService {
    DrugRepository drugRepository;

    @Autowired
    public DrugService(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    @Override
    public List<Drug> findAll() {
        List<Drug> drugs = new LinkedList<>();
        drugRepository.findAll().iterator().forEachRemaining(drugs::add);
        return drugs;
    }

    @Override
    public Drug findById(Long Id) {
        Optional<Drug> optionalDrug = drugRepository.findById(Id);
        if (optionalDrug.isEmpty()) {
            throw new ResourceNotFoundException("Drug " + Id + " not found!");
        }
        return optionalDrug.get();
    }

    @Override
    public Drug save(Drug entity) {
        return drugRepository.save(entity);
    }

    @Override
    public void deleteById(Long Id) {
        Optional<Drug> optionalDrug = drugRepository.findById(Id);
        if (optionalDrug.isEmpty()) {
            throw new ResourceNotFoundException("Drug " + Id + " not found!");
        }
        drugRepository.deleteById(Id);
    }
}
